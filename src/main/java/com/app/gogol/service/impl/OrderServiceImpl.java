package com.app.gogol.service.impl;

import com.app.gogol.bean.OrderDto;
import com.app.gogol.bean.OrderInfo;
import com.app.gogol.bean.OrderItemDto;
import com.app.gogol.entity.Order;
import com.app.gogol.entity.OrderItem;
import com.app.gogol.entity.Product;
import com.app.gogol.exception.OrderNotFoundException;
import com.app.gogol.repository.OrderRepository;
import com.app.gogol.request.NewOrderRequest;
import com.app.gogol.request.NewOrderRequest.Item;
import com.app.gogol.service.OrderItemService;
import com.app.gogol.service.OrderService;
import com.app.gogol.service.ProductService;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.app.gogol.entity.Order.Status.CREATED;
import static com.app.gogol.util.DeliveryPriceUtil.getDeliveryPrice;
import static java.lang.Boolean.TRUE;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * @author unalpolat
 */
@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository repository;

  private final ProductService productService;

  private final OrderItemService orderItemService;

  public OrderServiceImpl(OrderRepository repository, ProductService productService,
                          OrderItemService orderItemService) {
    this.repository = repository;
    this.productService = productService;
    this.orderItemService = orderItemService;
  }

  @Override
  public OrderDto get(Long id) throws OrderNotFoundException {
    Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    return OrderDto.from(order);
  }

  @Override
  public OrderInfo getOrderInfo(Long id) throws OrderNotFoundException {
    OrderDto orderDto = get(id);
    //
    List<OrderItem> orderItems = orderItemService.get(id);
    Set<Long> productIds = orderItems.stream().map(OrderItem::getProductId).collect(toSet());
    List<Product> products = productService.getByIds(productIds);
    Map<Long, Product> idProductMap = products.stream().collect(toMap(Product::getId, identity()));
    List<OrderItemDto> orderItemDtos = orderItems.stream()
                                                 .map(oi -> OrderItemDto.from(oi, idProductMap.get(oi.getProductId())))
                                                 .collect(toList());
    return new OrderInfo(orderDto, orderItemDtos);
  }

  @Override
  public List<OrderDto> getCustomerOrders(Long customerId) {
    return repository.findByCustomerId(customerId).stream().map(OrderDto::from).collect(toList());
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public OrderInfo newOrder(NewOrderRequest request) {
    Set<Long> itemIds = request.getItems().stream().map(Item::getId).collect(toSet());
    List<Product> products = productService.getByIds(itemIds);
    Date now = new Date();
    Order order = createNewOrder(request, products, now);
    List<OrderItem> orderItems = createOrderItems(order.getId(), request.getItems(), products, now);
    destock(products, request.getItems());
    return createOrderInfo(order, products, orderItems);
  }

  private Order createNewOrder(NewOrderRequest request, Collection<Product> products, Date now) {
    Order order = new Order();
    order.setCustomerId(request.getCustomerId());
    order.setNote(request.getNote());
    order.setAddressId(request.getAddressId());
    order.setAddressDetails(request.getAddressDetails());
    order.setDeliveryDate(request.getDeliveryDate());
    //
    Integer totalItemPrice = calculateTotalItemPrice(request.getItems(), products);
    order.setTotalItemPrice(totalItemPrice);
    //
    order.setDeliveryPrice(getDeliveryPrice(totalItemPrice));
    order.setActive(TRUE);
    order.setStatus(CREATED);
    order.setCreatedAt(now);
    order.setLastUpdatedAt(now);
    return repository.save(order);
  }

  private Integer calculateTotalItemPrice(List<Item> items, Collection<Product> products) {
    return items.stream().map(item -> products.stream()
                                              .filter(op -> op.getId().equals(item.getId()))
                                              .map(Product::getPrice)
                                              .map(p -> p * item.getQuantity())
                                              .findFirst()
                                              .get()
                             ).reduce(0, Integer::sum);
  }

  private List<OrderItem> createOrderItems(Long orderId, List<Item> items, List<Product> products, Date now) {
    Map<Long, Integer> idPriceMap = products.stream().collect(toMap(Product::getId, Product::getPrice));
    List<OrderItem> orderItems = items.stream().map(item -> {
      OrderItem orderItem = new OrderItem();
      orderItem.setOrderId(orderId);
      orderItem.setProductId(item.getId());
      orderItem.setQuantity(item.getQuantity());
      orderItem.setNote(item.getNote());
      orderItem.setPrice(idPriceMap.get(item.getId()));
      orderItem.setCreatedAt(now);
      orderItem.setLastUpdatedAt(now);
      return orderItem;
    }).collect(toList());
    return orderItemService.addAll(orderItems);
  }

  private OrderInfo createOrderInfo(Order order, List<Product> products, List<OrderItem> orderItems) {
    OrderDto orderDto = OrderDto.from(order);
    Map<Long, Product> idProductMap = products.stream().collect(toMap(Product::getId, identity()));
    List<OrderItemDto> orderItemDtos = orderItems.stream()
                                                 .map(oi -> OrderItemDto.from(oi, idProductMap.get(oi.getProductId())))
                                                 .collect(toList());
    return new OrderInfo(orderDto, orderItemDtos);
  }

  // todo make it batch
  private void destock(List<Product> orderProducts, List<Item> requestItems) {
    Map<Long, Integer> idQuantityMap = requestItems.stream().collect(toMap(Item::getId, Item::getQuantity));
    orderProducts.forEach(product -> {
      Integer newQuantity = product.getStockQuantity() - idQuantityMap.get(product.getId());
      productService.destock(product.getId(), newQuantity);
    });
  }
}

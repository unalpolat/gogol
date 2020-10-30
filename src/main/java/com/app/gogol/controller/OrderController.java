package com.app.gogol.controller;

import com.app.gogol.bean.OrderDto;
import com.app.gogol.bean.OrderInfo;
import com.app.gogol.exception.OrderNotFoundException;
import com.app.gogol.request.NewOrderRequest;
import com.app.gogol.response.AppResponse;
import com.app.gogol.service.OrderService;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author unalpolat
 */
@Api(value = "Order API", tags = "Order")
@RestController
@Validated
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/{id}")
  public AppResponse<OrderDto> getOrder(@PathVariable Long id) throws OrderNotFoundException {
    return AppResponse.successful(orderService.get(id));
  }

  @GetMapping("/infos/{id}")
  public AppResponse<OrderInfo> getOrderInfo(@PathVariable Long id) throws OrderNotFoundException {
    return AppResponse.successful(orderService.getOrderInfo(id));
  }

  @GetMapping("/customers/{customerId}")
  public AppResponse<List<OrderDto>> getCustomerOrders(@PathVariable Long customerId) {
    return AppResponse.successful(orderService.getCustomerOrders(customerId));
  }

  @PostMapping
  public AppResponse<OrderInfo> newOrder(@Validated @RequestBody NewOrderRequest request) {
    return AppResponse.successful(orderService.newOrder(request));
  }
}

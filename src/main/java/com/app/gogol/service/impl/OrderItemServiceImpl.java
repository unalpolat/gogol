package com.app.gogol.service.impl;

import com.app.gogol.entity.OrderItem;
import com.app.gogol.repository.OrderItemRepository;
import com.app.gogol.service.OrderItemService;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author unalpolat
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemRepository repository;

  public OrderItemServiceImpl(OrderItemRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<OrderItem> get(Long orderId) {
    return repository.selectByOrderId(orderId);
  }

  @Override
  public List<OrderItem> addAll(Collection<OrderItem> items) {
    return repository.saveAll(items);
  }
}

package com.app.gogol.service;

import com.app.gogol.entity.OrderItem;
import java.util.Collection;
import java.util.List;

/**
 * @author unalpolat
 */
public interface OrderItemService {

  List<OrderItem> get(Long orderId);

  List<OrderItem> addAll(Collection<OrderItem> item);
}

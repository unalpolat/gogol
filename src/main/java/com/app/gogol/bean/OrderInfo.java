package com.app.gogol.bean;

import java.util.List;

/**
 * @author unalpolat
 */
public class OrderInfo {

  private final OrderDto order;

  private final List<OrderItemDto> orderItems;

  public OrderInfo(OrderDto order, List<OrderItemDto> orderItems) {
    this.order = order;
    this.orderItems = orderItems;
  }

  public OrderDto getOrder() {
    return order;
  }

  public List<OrderItemDto> getOrderItems() {
    return orderItems;
  }

  @Override
  public String toString() {
    return "OrderInfo{" +
           "order=" + order +
           ", orderItems=" + orderItems +
           '}';
  }
}

package com.app.gogol.service;

import com.app.gogol.bean.OrderDto;
import com.app.gogol.bean.OrderInfo;
import com.app.gogol.exception.OrderNotFoundException;
import com.app.gogol.request.NewOrderRequest;
import java.util.List;

/**
 * @author unalpolat
 */
public interface OrderService {

  OrderDto get(Long id) throws OrderNotFoundException;

  OrderInfo getOrderInfo(Long id) throws OrderNotFoundException;

  List<OrderDto> getCustomerOrders(Long customerId);

  OrderInfo newOrder(NewOrderRequest request);
}

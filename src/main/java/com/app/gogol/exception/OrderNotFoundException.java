package com.app.gogol.exception;

import static com.app.gogol.bean.GogolErrorCodes.ORDER_NOT_FOUND;

/**
 * @author unalpolat
 */
public class OrderNotFoundException extends AbstractAppException {

  public OrderNotFoundException(Long id) {
    super(ORDER_NOT_FOUND, "Order not found for id: " + id);
  }
}

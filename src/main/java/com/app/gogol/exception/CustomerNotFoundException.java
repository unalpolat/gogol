package com.app.gogol.exception;

import static com.app.gogol.bean.GogolErrorCodes.CUSTOMER_NOT_FOUND;

/**
 * @author unalpolat
 */
public class CustomerNotFoundException extends AbstractAppException {

  public CustomerNotFoundException(Long id) {
    super(CUSTOMER_NOT_FOUND, "Customer not found for id: " + id);
  }
}

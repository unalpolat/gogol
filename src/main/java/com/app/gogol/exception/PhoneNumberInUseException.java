package com.app.gogol.exception;

import static com.app.gogol.bean.GogolErrorCodes.PHONE_NUMBER_IN_USE;

/**
 * @author unalpolat
 */
public class PhoneNumberInUseException extends AbstractAppException {

  public PhoneNumberInUseException() {
    super(PHONE_NUMBER_IN_USE, "Phone number already exists");
  }
}

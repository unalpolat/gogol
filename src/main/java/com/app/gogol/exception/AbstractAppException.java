package com.app.gogol.exception;

/**
 * @author unalpolat
 */
public abstract class AbstractAppException extends Exception {

  private final Integer errorCode;

  private final String errorDetail;

  protected AbstractAppException(Integer errorCode, String message) {
    this(errorCode, message, message);
  }

  private AbstractAppException(Integer errorCode, String message, String errorDetail) {
    super(message);
    this.errorCode = errorCode;
    this.errorDetail = errorDetail;
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public String getErrorDetail() {
    return errorDetail;
  }
}

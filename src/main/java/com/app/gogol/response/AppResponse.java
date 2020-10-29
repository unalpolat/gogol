package com.app.gogol.response;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author unalpolat
 */
public class AppResponse<T> {

  private static final AppResponse VOID_SUCCESS = successful(null);

  private final Integer status;

  private final Boolean successful;

  private final String errorCode;

  private final String errorDetail;

  private final String errorMessageKey;

  private final T data;

  private AppResponse(Integer status, Boolean successful, String errorCode, String errorDetail,
                      String errorMessageKey, T data) {
    this.status = status;
    this.successful = successful;
    this.errorCode = errorCode;
    this.errorDetail = errorDetail;
    this.errorMessageKey = errorMessageKey;
    this.data = data;
  }

  public static <T> AppResponse<T> successful(T data) {
    return new AppResponse<>(OK.value(), true, null, null, null, data);
  }

  public static AppResponse successful() {
    return VOID_SUCCESS;
  }

  public Integer getStatus() {
    return status;
  }

  public Boolean getSuccessful() {
    return successful;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorDetail() {
    return errorDetail;
  }

  public String getErrorMessageKey() {
    return errorMessageKey;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    return "AppResponse{" +
           "status=" + status +
           ", successful=" + successful +
           ", errorCode='" + errorCode + '\'' +
           ", errorDetail='" + errorDetail + '\'' +
           ", errorMessageKey='" + errorMessageKey + '\'' +
           ", data=" + data +
           '}';
  }
}

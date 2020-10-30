package com.app.gogol.controller;

import com.app.gogol.bean.GogolErrorCodes;
import com.app.gogol.exception.AbstractAppException;
import com.app.gogol.response.AppResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.app.gogol.bean.GogolErrorCodes.METHOD_ARGUMENT_NOT_VALID;
import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

/**
 * @author unalpolat
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  private static final String KEY_PREFIX = "appExceptions.";

  private static final String INTERNAL_EXCEPTION_KEY = KEY_PREFIX + "internalException.";

  private static final String VALIDATION_EXCEPTION_KEY = KEY_PREFIX + "validationException.";

  @ExceptionHandler(AbstractAppException.class)
  public ResponseEntity<AppResponse> handleServiceException(AbstractAppException ex) {
    return ResponseEntity.ok(createFailedServiceResponse(BAD_REQUEST.value(),
                                                         ex.getErrorCode(),
                                                         ex.getErrorDetail(),
                                                         INTERNAL_EXCEPTION_KEY + ex.getClass().getSimpleName()));
  }

  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
    FieldError fieldError = ex.getBindingResult().getFieldError();
    assert fieldError != null;
    String errorDetail = format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage());
    return ResponseEntity.ok(createFailedServiceResponse(UNPROCESSABLE_ENTITY.value(),
                                                         METHOD_ARGUMENT_NOT_VALID,
                                                         errorDetail,
                                                         VALIDATION_EXCEPTION_KEY + ex.getClass().getSimpleName()));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<AppResponse> handleConstraintViolation(ConstraintViolationException ex) {
    return ResponseEntity.ok(createFailedServiceResponse(UNPROCESSABLE_ENTITY.value(),
                                                         GogolErrorCodes.CONSTRAINT_NOT_VALID,
                                                         ex.getMessage(),
                                                         VALIDATION_EXCEPTION_KEY + ex.getClass().getSimpleName()));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<AppResponse> handleRuntimeException(RuntimeException ex) {
    return ResponseEntity.ok(createFailedServiceResponse(INTERNAL_SERVER_ERROR.value(),
                                                         GogolErrorCodes.SERVER_ERROR,
                                                         ex.getMessage(),
                                                         INTERNAL_EXCEPTION_KEY + ex.getClass().getSimpleName()));
  }

  private AppResponse createFailedServiceResponse(Integer status,
                                                  Integer errorCode,
                                                  String errorDetail,
                                                  String messageKey) {
    return new AppResponse(status, false, errorCode, errorDetail, messageKey, null);
  }
}

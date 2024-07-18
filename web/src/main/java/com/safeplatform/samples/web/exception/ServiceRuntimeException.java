package com.safeplatform.samples.web.exception;

public class ServiceRuntimeException extends RuntimeException {
  private int statusCode;

  public ServiceRuntimeException(int statusCode, String message) {
    super(message);
    this.statusCode = statusCode;
  }
}

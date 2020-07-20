package com.avocado.boot.starter.core.enums;

public enum SystemErrorType implements ErrorType {
  SYSTEM_ERROR("系统异常，请联系管理员或稍后重试.");

  /**
   * 错误类型描述信息
   */
  private String message;

  SystemErrorType(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}

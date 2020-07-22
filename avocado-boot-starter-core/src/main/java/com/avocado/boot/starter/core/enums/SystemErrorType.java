package com.avocado.boot.starter.core.enums;

public enum SystemErrorType implements ErrorType {
  CUSTOM_ERROR("自定义异常信息."),
  UNAUTHORIZED_EXCEPTION("无权访问."),
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

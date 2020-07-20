package com.avocado.boot.starter.core.enums;

import cn.hutool.http.HttpStatus;

public interface ErrorType {

  /**
   * 返回code
   */
  default int getCode(){
    return HttpStatus.HTTP_CONFLICT;
  }

  /**
   * 返回message
   */
  String getMessage();

}

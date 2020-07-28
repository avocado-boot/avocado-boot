package com.avocado.boot.starter.core.exception;

import cn.hutool.core.collection.CollUtil;
import com.avocado.boot.starter.core.enums.ErrorType;
import com.avocado.boot.starter.core.enums.SystemErrorType;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义业务异常
 *
 * @author qiaoliang
 */
public class BusinessException extends RuntimeException {

  /**
   * 异常对应的错误类型
   */
  private final ErrorType errorType;

  public BusinessException(ErrorType errorType) {
    super(errorType.getMessage());
    this.errorType = errorType;
  }

  public BusinessException(String message) {
    super(message);
    this.errorType = SystemErrorType.CUSTOM_ERROR;
  }

  public ErrorType getErrorType() {
    return errorType;
  }

  public static void isTrue(boolean expression,ErrorType errorType) {
    if(expression){
      throw new BusinessException(errorType);
    }
  }

  public static void isFalse(boolean expression,ErrorType errorType) {
    if(!expression){
      throw new BusinessException(errorType);
    }
  }

  public static void isNull(Object object,ErrorType errorType) {
    if(Objects.isNull(object)){
      throw new BusinessException(errorType);
    }
  }

  public static void isNonNull(Object object,ErrorType errorType) {
    if(Objects.nonNull(object)){
      throw new BusinessException(errorType);
    }
  }

  public static void isNotEmpty(Collection<?> collection, ErrorType errorType) {
    if(CollUtil.isNotEmpty(collection)){
      throw new BusinessException(errorType);
    }
  }

  public static void isNotEmpty(Map<?, ?> map, ErrorType errorType) {
    if(CollUtil.isNotEmpty(map)){
      throw new BusinessException(errorType);
    }
  }

  public static void isEmpty(Collection<?> collection, ErrorType errorType) {
    if(CollUtil.isEmpty(collection)){
      throw new BusinessException(errorType);
    }
  }

  public static void isEmpty(Map<?, ?> map, ErrorType errorType) {
    if(CollUtil.isEmpty(map)){
      throw new BusinessException(errorType);
    }
  }


}

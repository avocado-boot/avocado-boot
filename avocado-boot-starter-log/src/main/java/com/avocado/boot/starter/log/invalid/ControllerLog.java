package com.avocado.boot.starter.log.invalid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ： qiaoliang
 * @description : 系统操作日志注解
 * @date ： 2020-04-16
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerLog {

  /**方法描述**/
  String discription() default "-";

}

package com.avocado.boot.starter.log.annotation;

import com.avocado.boot.starter.log.LogConfigurer;
import com.avocado.boot.starter.log.Logs;

/**
 * @author ：qiaoliang
 * @date ：2020-07-20
 */
public interface LogConfigurerAnnotation extends LogConfigurer {

    default void before(Logs logs){
    }

}

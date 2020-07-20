package com.avocado.boot.starter.log.annotation;

import com.avocado.boot.starter.log.LogConfigurer;
import com.avocado.boot.starter.log.Logs;

/**
 * @author ：qiaoliang
 * @date ：2020-07-20
 */
public interface LogConfigurerSupport extends LogConfigurer {

    @Override
    default void before(Logs logs){
    }

    @Override
    default void doAfterReturning(Logs logs){

    }

    @Override
    default void doAfterThrowing(Logs logs){

    }

}

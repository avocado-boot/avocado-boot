package com.avocado.boot.starter.log.annotation;

import com.avocado.boot.starter.log.LogConfigurer;
import com.avocado.boot.starter.log.Logs;

/**
 * @author ：qiaoliang
 * @date ：2020-07-20
 */
public class LogConfigurerSupport implements LogConfigurer {

    @Override
    public void before(Logs logs){
    }

    @Override
    public void doAfterReturning(Logs logs){

    }

    @Override
    public void doAfterThrowing(Logs logs){

    }

}

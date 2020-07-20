package com.avocado.boot.starter.log.annotation;

import com.avocado.boot.starter.log.Logs;

/**
 * @author ：qiaoliang
 * @date ：2020-07-16
 */
public class LogConfigurerSupport implements LogConfigurerAnnotation{

    @Override
    public void doAfterReturning(Logs logs) {

    }

    @Override
    public void doAfterThrowing(Logs logs) {

    }

}

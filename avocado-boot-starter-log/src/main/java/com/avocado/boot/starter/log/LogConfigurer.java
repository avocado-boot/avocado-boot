package com.avocado.boot.starter.log;

/**
 * @author ：qiaoliang
 * @date ：2020-07-16
 */
public interface LogConfigurer {

    void before(Logs logs);

    void doAfterReturning(Logs logs);

    void doAfterThrowing(Logs logs);

}

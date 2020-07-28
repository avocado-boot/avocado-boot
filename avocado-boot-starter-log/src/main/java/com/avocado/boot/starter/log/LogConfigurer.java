package com.avocado.boot.starter.log;

/**
 * @author ：qiaoliang
 */
public interface LogConfigurer {

    void before(Logs logs);

    void doAfterReturning(Logs logs);

    void doAfterThrowing(Logs logs);

}

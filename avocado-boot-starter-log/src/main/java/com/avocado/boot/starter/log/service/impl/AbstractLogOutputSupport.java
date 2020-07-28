package com.avocado.boot.starter.log.service.impl;

import com.avocado.boot.starter.log.Logs;
import com.avocado.boot.starter.log.enums.LogLevelType;
import com.avocado.boot.starter.log.service.LogOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：qiaoliang
 */
public abstract class AbstractLogOutputSupport implements LogOutput {

    private static final Logger log = LoggerFactory.getLogger(AbstractLogOutputSupport.class);

    @Override
    public abstract void businessLog(Logs logs);

    @Override
    public abstract void before(Logs logs);

    @Override
    public void doAfterReturning(Logs logs){

    }

    @Override
    public void doAfterThrowing(Logs logs) {
        log.error("发生异常时间：{}", logs.getErrorTime());
        log.error("抛出异常：{}", logs.getErrorCountent());
    }

    @Override
    public abstract LogLevelType getFlag();

}

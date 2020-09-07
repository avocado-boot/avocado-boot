package com.avocado.boot.starter.log.service.impl;

import com.avocado.boot.starter.log.Logs;
import com.avocado.boot.starter.log.enums.LogLevelType;
import com.avocado.boot.starter.log.service.LogOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ：qiaoliang
 */
@Component
public class InfoLogOutputSupport extends AbstractLogOutputSupport implements LogOutput {

    private static final Logger log = LoggerFactory.getLogger(InfoLogOutputSupport.class);

    @Override
    public void businessLog(Logs logs) {
        log.info("发生业务异常时间：{}", logs.getErrorTime());
        log.info("抛出业务异常：{}", logs.getErrorCountent());
    }

    @Override
    public void before(Logs logs) {
        log.info("请求Url : {}", logs.getUrl());
        log.info("请求方式 : {}", logs.getMethod());
        log.info("请求方法 : {}", logs.getMethodName());
        log.info("请求功能 : {}", logs.getBusinessType());
        log.info("请求用户 : {}", logs.getCurrUserId());
        log.info("用户类别 : {}", logs.getOperatorType());
        log.info("请求参数 : {}", logs.getInputParam());
        log.info("请求开始时间：{}", logs.getStartTime());
    }

    @Override
    public void doAfterReturning(Logs logs) {
        log.info("请求结束时间：{}", logs.getEndTime());
        log.info("请求耗时：{}", logs.getConsumingTime());
        // 处理完请求，返回内容
        log.info("请求返回 : {}", logs.getOutParam());
    }

    @Override
    public LogLevelType getFlag() {
        return LogLevelType.INFO;
    }

}

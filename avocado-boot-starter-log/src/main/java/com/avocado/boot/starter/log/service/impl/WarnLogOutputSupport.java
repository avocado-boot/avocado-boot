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
public class WarnLogOutputSupport extends AbstractLogOutputSupport implements LogOutput {

    private static final Logger log = LoggerFactory.getLogger(WarnLogOutputSupport.class);

    @Override
    public void businessLog(Logs logs) {
        log.warn("发生业务异常时间：{}", logs.getErrorTime());
        log.warn("抛出业务异常：{}", logs.getErrorCountent());
    }

    @Override
    public void before(Logs logs) {
        log.warn("请求开始时间：{}", logs.getStartTime());
        log.warn("请求Url : {}", logs.getUrl());
        log.warn("请求方式 : {}", logs.getMethod());
        log.warn("请求方法 : {}", logs.getMethodName());
        log.warn("请求用户 : {}", logs.getCurrUserId());
        log.warn("请求参数 : {}", logs.getInputParam());
    }

    @Override
    public void doAfterReturning(Logs logs) {
        log.warn("请求结束时间：{}", logs.getEndTime());
        log.warn("请求耗时：{}", logs.getConsumingTime());
        // 处理完请求，返回内容
        log.warn("请求返回 : {}", logs.getOutParam());
    }

    @Override
    public LogLevelType getFlag() {
        return LogLevelType.WARN;
    }

}

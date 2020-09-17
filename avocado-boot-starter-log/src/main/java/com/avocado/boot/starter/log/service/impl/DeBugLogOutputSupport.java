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
public class DeBugLogOutputSupport extends AbstractLogOutputSupport implements LogOutput {

    private static final Logger log = LoggerFactory.getLogger(DeBugLogOutputSupport.class);

    @Override
    public void businessLog(Logs logs) {
        log.debug("发生业务异常时间：{}", logs.getErrorTime());
        log.debug("抛出业务异常：{}", logs.getErrorCountent());
    }

    @Override
    public void before(Logs logs) {
        log.debug("请求Url : {}", logs.getUrl());
        log.debug("请求方式 : {}", logs.getMethod());
        log.debug("请求方法 : {}", logs.getMethodName());
        log.debug("功能模块 : {}", logs.getBusinessType());
        log.debug("方法描述 : {}", logs.getDiscription());
        log.debug("请求用户 : {}", logs.getCurrUserId());
        log.debug("用户类别 : {}", logs.getOperatorType());
        log.debug("请求参数 : {}", logs.getInputParam());
        log.debug("请求开始时间：{}", logs.getStartTime());
    }

    @Override
    public void doAfterReturning(Logs logs) {
        log.debug("请求结束时间：{}", logs.getEndTime());
        log.debug("请求耗时：{}", logs.getConsumingTime());
        // 处理完请求，返回内容
        log.debug("请求返回 : {}", logs.getOutParam());
    }

    @Override
    public LogLevelType getFlag() {
        return LogLevelType.DEBUG;
    }

}

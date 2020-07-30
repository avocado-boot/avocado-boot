package com.avocado.boot.starter.log.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.avocado.boot.starter.log.LogConfigurer;
import com.avocado.boot.starter.log.Logs;
import com.avocado.boot.starter.log.event.SystemErrorLogEvent;
import com.avocado.boot.starter.log.event.SystemLogEvent;
import com.avocado.boot.starter.log.event.SystemLogEventPublisher;
import com.avocado.boot.starter.log.event.SystemSuccessLogEvent;

/**
 * @author ：qiaoliang
 */
public class LogConfigurerSupport implements LogConfigurer {

    private SystemLogEventPublisher systemLogEventPublisher;

    @Override
    public void before(Logs logs){
        SystemLogEvent systemLogEvent = new SystemLogEvent();
        BeanUtil.copyProperties(logs,systemLogEvent);
        systemLogEventPublisher.asyncPublish(systemLogEvent);
    }

    @Override
    public void doAfterReturning(Logs logs){
        SystemSuccessLogEvent systemLogEvent = new SystemSuccessLogEvent();
        BeanUtil.copyProperties(logs,systemLogEvent);
        systemLogEventPublisher.asyncPublish(systemLogEvent);
    }

    @Override
    public void doAfterThrowing(Logs logs){
        SystemErrorLogEvent systemLogEvent = new SystemErrorLogEvent();
        BeanUtil.copyProperties(logs,systemLogEvent);
        systemLogEventPublisher.asyncPublish(systemLogEvent);
    }

    public void systemLogEventPublisher(SystemLogEventPublisher systemLogEventPublisher){
        this.systemLogEventPublisher = systemLogEventPublisher;
    }

}

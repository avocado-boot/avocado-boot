package com.avocado.boot.starter.log.event;

import java.util.Date;

/**
 * 日志事件模型
 *
 * @author ：qiaoliang
 */
public class SystemErrorLogEvent extends SystemLogEvent {

    private Date errorTime;

    private String errorCountent;

    public SystemErrorLogEvent() {
    }

    public SystemErrorLogEvent(String currUserId, String inputParam, String outParam, String methodName, String method, String url, String businessType, String operatorType, Date errorTime, String errorCountent) {
        super(currUserId, inputParam, outParam, methodName, method, url, businessType, operatorType);
        this.errorTime = errorTime;
        this.errorCountent = errorCountent;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public String getErrorCountent() {
        return errorCountent;
    }

    public void setErrorCountent(String errorCountent) {
        this.errorCountent = errorCountent;
    }
}

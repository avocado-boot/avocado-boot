package com.avocado.boot.starter.log.event;

import com.avocado.boot.starter.core.bus.event.AbstractDomainEvent;

import java.util.Date;

/**
 * 日志事件模型
 *
 * @author ：qiaoliang
 */
public class SystemLogEvent extends AbstractDomainEvent {
    /**请求用户**/
    private String currUserId;
    /**请求参数**/
    private String inputParam;
    /**返回参数**/
    private String outParam;
    /**请求方法**/
    private String methodName;
    /**请求方式**/
    private String method;
    /**请求Url**/
    private String url;

    public SystemLogEvent() {
    }

    public SystemLogEvent(String currUserId, String inputParam, String outParam, String methodName, String method, String url) {
        this.currUserId = currUserId;
        this.inputParam = inputParam;
        this.outParam = outParam;
        this.methodName = methodName;
        this.method = method;
        this.url = url;
    }

    public String getCurrUserId() {
        return currUserId;
    }

    public void setCurrUserId(String currUserId) {
        this.currUserId = currUserId;
    }

    public String getInputParam() {
        return inputParam;
    }

    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }

    public String getOutParam() {
        return outParam;
    }

    public void setOutParam(String outParam) {
        this.outParam = outParam;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

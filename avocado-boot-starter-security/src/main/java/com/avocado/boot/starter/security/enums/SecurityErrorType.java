package com.avocado.boot.starter.security.enums;

import cn.hutool.http.HttpStatus;
import com.avocado.boot.starter.core.enums.ErrorType;

/**
 * @author ：qiaoliang
 */
public enum  SecurityErrorType implements ErrorType {
    ACCESS_DENIED_EXCEPTION("无权访问."),
    NO_ACCESS_ERROR("token失效或证书错误."),
    ;

    private int code;
    private String message;

    SecurityErrorType(String message) {
        this.code = HttpStatus.HTTP_UNAUTHORIZED;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

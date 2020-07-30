package com.avocado.boot.starter.oauth.infrastructure.enums;

import cn.hutool.http.HttpStatus;
import com.avocado.boot.starter.core.enums.ErrorType;

/**
 * @author ：qiaoliang
 */
public enum  OauthErrorType implements ErrorType {
    PASSWORD_ERROR("用户密码错误."),
    NON_CREDENTIALS_EXPIRED_ERROR("凭证已过期."),
    NON_LOCKED_ERROR("账号已锁定."),
    NON_ENABLE_ERROR("账号已禁用."),
    NON_EXPIRED_ERROR("账号已过期."),
    NON_USER_ERROR("用户不存在."),
    NON_EMPTY_CODE_ERROR("授权码不能为空."),
    INVALID_CODE_ERROR("无效的授权码."),
    INVALID_CLIENT_ID_ERROR("无效的客户端ID."),
    INVALID_CLIENT_SECRET_ERROR("无效的客户端密钥."),
    ;

    private int code;
    private String message;

    OauthErrorType(String message) {
        this.code = HttpStatus.HTTP_CONFLICT;
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

package com.avocado.boot.starter.oauth.infrastructure.enums;


/**
 * 认证模式
 *
 * @author ：qiaoliang
 */
public enum GrantType{

    /**
     * 密码模式
     */
    password,

    /**
     * 客户端模式
     */
    client_credentials,

    /**
     * 授权码模式
     */
    authorization_code,
    ;
}

package com.avocado.boot.starter.oauth.application.dto;

import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;

import javax.validation.constraints.NotNull;

/**
 * @author ：qiaoliang
 */
public class OauthParameter {

    /**认证方式**/
    @NotNull(message = "认证方式不能为空.")
    private GrantType grantType;

    /**用户名,密码模式时必填**/
    private String username;

    /**密码,密码模式时必填**/
    private String password;

    /**客户端Id**/
    @NotNull(message = "客户端ID不能为空.")
    private String clientId;

    /**客户端密钥**/
    @NotNull(message = "客户端密钥不能为空.")
    private String clientSecret;

    /**授权码,授权码模式必填**/
    private String code;

    public GrantType getGrantType() {
        return grantType;
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

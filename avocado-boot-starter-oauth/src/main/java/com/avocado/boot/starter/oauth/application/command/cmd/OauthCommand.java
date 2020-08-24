package com.avocado.boot.starter.oauth.application.command.cmd;

import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ：qiaoliang
 */
@ApiModel(value="Oauth认证请求模型", description="Oauth认证请求使用")
public class OauthCommand{

    @ApiModelProperty(value = "认证方式" , required = true)
    @NotNull(message = "认证方式不能为空.")
    private GrantType grantType;

    @ApiModelProperty(value = "用户名,密码模式时必填")
    private String username;

    @ApiModelProperty(value = "密码,密码模式时必填")
    private String password;

    @ApiModelProperty(value = "客户端Id" , required = true)
    @NotBlank(message = "客户端ID不能为空.")
    private String clientId;

    @ApiModelProperty(value = "客户端密钥" , required = true)
    @NotBlank(message = "客户端密钥不能为空.")
    private String clientSecret;

    @ApiModelProperty(value = "授权码,授权码模式必填")
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

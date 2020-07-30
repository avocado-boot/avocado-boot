package com.avocado.boot.starter.oauth.domain;

/**
 * 授权码
 *
 * @author ：qiaoliang
 */
public class GrantCode implements java.io.Serializable {

    /**授权码,必须全局唯一,避免出现重复**/
    private String code;

    /**用户Id**/
    private Long userId;

    /**Oauth客户端信息**/
    private OauthClient client;

    public GrantCode() {
    }

    public GrantCode(String code, Long userId, OauthClient client) {
        this.code = code;
        this.userId = userId;
        this.client = client;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OauthClient getClient() {
        return client;
    }

    public void setClient(OauthClient client) {
        this.client = client;
    }
}

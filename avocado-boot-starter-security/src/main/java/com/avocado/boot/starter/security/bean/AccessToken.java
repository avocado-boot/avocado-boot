package com.avocado.boot.starter.security.bean;

/**
 * @author ：qiaoliang
 */
public class AccessToken implements java.io.Serializable {

    /**访问令牌**/
    private String token;

    /**有效期时间**/
    private long expired;

    public AccessToken(String token, long expired) {
        this.token = token;
        this.expired = expired;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpired() {
        return expired;
    }

    public void setExpired(long expired) {
        this.expired = expired;
    }
}

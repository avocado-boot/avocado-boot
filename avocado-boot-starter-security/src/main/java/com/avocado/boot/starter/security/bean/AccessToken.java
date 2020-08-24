package com.avocado.boot.starter.security.bean;

/**
 * @author ：qiaoliang
 */
public class AccessToken implements java.io.Serializable {

    /**访问令牌**/
    private String token;

    /**有效期时间**/
    private long expiresIn;

    public AccessToken(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = (expiresIn-1);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}

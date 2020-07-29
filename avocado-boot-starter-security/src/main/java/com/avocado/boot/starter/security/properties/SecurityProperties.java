package com.avocado.boot.starter.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：qiaoliang
 */
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    /**Jwt Token 颁发者**/
    private String issuer;
    /**凭证信息**/
    private String cert;
    /**访问令牌有效期为1天**/
    private long time = 1000 * 60 * 60 * 24;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

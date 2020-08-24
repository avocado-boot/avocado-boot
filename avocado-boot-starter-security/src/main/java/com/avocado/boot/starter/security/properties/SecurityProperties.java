package com.avocado.boot.starter.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：qiaoliang
 */
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    /**Jwt Token 颁发者**/
    private String issuer = "avocado";
    /**凭证信息**/
    private String cert = "ix4bhR&$aS6^K29J8ZuhePoWi$H$qkQURPT&uGte4fJES^7UOKaTUHP0mwsj";
    /**不拦截地址配置 多个请用，号隔开**/
    private String[] exclude = new String[]{};

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

    public String[] getExclude() {
        return exclude;
    }

    public void setExclude(String[] exclude) {
        this.exclude = exclude;
    }
}

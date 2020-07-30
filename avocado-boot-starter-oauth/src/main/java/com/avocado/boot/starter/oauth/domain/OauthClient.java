package com.avocado.boot.starter.oauth.domain;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.mybatis.bean.BaseEntity;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.util.DigestUtils;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;
import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_SECRET_ERROR;

/**
 * @author ：qiaoliang
 */
@TableName(autoResultMap = true)
public class OauthClient extends BaseEntity {

    /**加密盐**/
    private String salt;
    /**客户端密钥**/
    private String secret;
    /**授权方式**/
    private GrantType grantType;
    /**应用名称**/
    private String appName;
    /**应用Logo**/
    private String appLogo;
    /**应用描述**/
    private String appDesc;
    /**回调地址**/
    private String callback;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 客户端ID校验
     *
     * @author ：qiaoliang
     * @param clientId : 参数ID
     */
    public void checkClientId(String clientId){
        BusinessException.isFalse(this.getId().toString().equals(clientId),INVALID_CLIENT_ID_ERROR);
    }

    /**
     * 客户端秘钥校验
     *
     * @author ：qiaoliang
     * @param clientSecret : 参数秘钥
     */
    public void checkClientSecret(String clientSecret){
        BusinessException.isFalse(DigestUtils.md5DigestAsHex((clientSecret + this.getSalt()).getBytes())
                        .equals(this.getSecret()),
                INVALID_CLIENT_SECRET_ERROR);
    }

}

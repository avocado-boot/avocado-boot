package com.avocado.boot.starter.oauth.domain;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.core.util.RandomValueUtils;
import com.avocado.boot.starter.mybatis.basic.BaseEntity;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.util.DigestUtils;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;
import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_SECRET_ERROR;

/**
 * @author ：qiaoliang
 */
@TableName(autoResultMap = true)
public class OauthClient extends BaseEntity<Long,Long> {

    /**加密盐**/
    private String salt;
    /**客户端ID**/
    private String clientId;
    /**客户端密钥**/
    private String clientSecret;
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
    /**有效时间**/
    private Long expiresIn;

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

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * 客户端ID校验
     *
     * @author ：qiaoliang
     * @param clientId : 参数ID
     */
    public void checkClientId(String clientId){
        BusinessException.isFalse(this.getClientId().equals(clientId),INVALID_CLIENT_ID_ERROR);
    }

    /**
     * 客户端秘钥校验
     *
     * @author ：qiaoliang
     * @param clientSecret : 参数秘钥
     */
    public void checkClientSecret(String clientSecret){
        BusinessException.isFalse(DigestUtils.md5DigestAsHex((clientSecret + this.getSalt()).getBytes())
                        .equals(this.getClientSecret()),
                INVALID_CLIENT_SECRET_ERROR);
    }

    /**
     * 加密
     *
     * @author ：qiaoliang
     */
    public void encryptionClientSecret(){
        this.setClientId(RandomValueUtils.randomString(10));
        this.setClientSecret(DigestUtils.md5DigestAsHex((this.getClientSecret() + this.getSalt()).getBytes()));
    }

}

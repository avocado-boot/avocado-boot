package com.avocado.boot.starter.security.service;

import com.avocado.boot.starter.security.bean.AccessToken;
import com.avocado.boot.starter.security.bean.Authentication;

/**
 *
 * @author ：qiaoliang
 */
public interface ISecurityService {

    /**
     * 根据访问令牌获取凭证信息
     *
     * @author ：qiaoliang
     * @param token : 访问令牌
     * @return com.avocado.boot.starter.security.bean.Authentication
     */
    Authentication getAuthentication(String token);

    /**
     * 生成访问令牌
     *
     * @author ：qiaoliang
     * @param authentication : 账号的认证信息
     * @return com.avocado.boot.starter.security.bean.AccessToken
     */
    AccessToken generateToken(Authentication authentication);

    /**
     * 移除访问令牌
     * @param token java.lang.String
     */
    default void removeToken(String token){

    }

}

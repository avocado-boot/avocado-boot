package com.avocado.boot.starter.security.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.redis.utils.RedisUtil;
import com.avocado.boot.starter.security.bean.AccessToken;
import com.avocado.boot.starter.security.bean.Authentication;
import com.avocado.boot.starter.security.service.ISecurityService;

import java.util.UUID;

import static com.avocado.boot.starter.security.enums.SecurityErrorType.NO_ACCESS_ERROR;

/**
 * @author ：qiaoliang
 * @date ：2020-08-10
 */
public class RedisSecurityService implements ISecurityService {

    public static final String SECURITY_TOKEN_KEY = "security:token:%s";

    @Override
    public Authentication getAuthentication(String token) {
        String key = String.format(SECURITY_TOKEN_KEY,token);
        //  从缓存中获取
        Authentication authentication = RedisUtil.hashGetBean(key,new Authentication());
        BusinessException.isNull(authentication,NO_ACCESS_ERROR);
        return authentication;
    }

    @Override
    public AccessToken generateToken(Authentication authentication) {
        //  生成访问令牌
        String token = UUID.randomUUID().toString();
        String cacheKey = String.format(SECURITY_TOKEN_KEY,token);
        //  保存到Redis中
        RedisUtil.hashsSetBean(cacheKey,authentication,authentication.getExpiresIn());
        return new AccessToken(token,authentication.getExpiresIn());
    }


    @Override
    public void removeToken(String token) {
        String cacheKey = String.format(SECURITY_TOKEN_KEY,token);
        RedisUtil.delete(cacheKey);
    }

}

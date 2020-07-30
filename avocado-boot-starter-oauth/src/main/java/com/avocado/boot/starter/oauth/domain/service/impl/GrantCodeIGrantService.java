package com.avocado.boot.starter.oauth.domain.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.domain.GrantCode;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.service.IGrantCodeService;
import com.avocado.boot.starter.redis.utils.RedisUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CODE_ERROR;

/**
 * @author ：qiaoliang
 * @date ：2020-07-30
 */
@Component
public class GrantCodeIGrantService implements IGrantCodeService {

    /**
     * 缓存名称
     */
    private final static String CACHE_NAME = "oauth:grant:code:%s";

    /**
     * 授权码有效期为15分钟
     */
    private final static long VALIDITY = 1000 * 60 * 15;

    @Override
    public GrantCode selectByCode(String code) {
        String cacheKey = String.format(CACHE_NAME,code);
        //  获取授权码
        Object grantCode = RedisUtil.get(cacheKey);
        BusinessException.isNull(grantCode,INVALID_CODE_ERROR);
        //  删除缓存
        RedisUtil.delete(cacheKey);
        return (GrantCode)grantCode;
    }

    @Override
    public GrantCode generateCode(Long userId, OauthClient client) {
        //  生成授权码
        String code = IdWorker.getIdStr();
        //  构建授权码对象
        GrantCode grantCode = new GrantCode(code, userId, client);
        String cacheKey = String.format(CACHE_NAME,code);
        //  保存到redis中,并设置有效期
        RedisUtil.set(cacheKey,VALIDITY,grantCode);
        return grantCode;
    }

}

package com.avocado.boot.starter.oauth.domain.repository;

import com.avocado.boot.starter.mybatis.service.BaseService;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;

/**
 * @author ：qiaoliang
 * @date ：2020-07-30
 */
public interface IOauthClientRepository extends BaseService<OauthClient> {

    /**
     * 根据客户端id及客户端类型获取客户端信息
     *
     * @author ：qiaoliang
     * @param clientId : 客户端ID
     * @param grantType : 客户端类型
     * @return com.avocado.boot.starter.oauth.domain.OauthClient
     */
    OauthClient selectByClientIdAndGrantType(String clientId, GrantType grantType);

}

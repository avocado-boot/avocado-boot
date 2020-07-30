package com.avocado.boot.starter.oauth.infrastructure.repository;

import com.avocado.boot.starter.mybatis.service.impl.BaseServiceImpl;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.repository.IOauthClientRepository;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.avocado.boot.starter.oauth.infrastructure.mapper.OauthClientMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;

/**
 * @author ：qiaoliang
 * @date ：2020-07-30
 */
@Repository
public class OauthClientRepository extends BaseServiceImpl<OauthClientMapper,OauthClient> implements IOauthClientRepository {

    @Override
    public OauthClient selectByClientIdAndGrantType(String clientId, GrantType grantType) {
        LambdaQueryWrapper<OauthClient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OauthClient::getId,clientId);
        queryWrapper.eq(OauthClient::getGrantType,grantType);
        return this.getOne(queryWrapper);
    }

}

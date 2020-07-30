package com.avocado.boot.starter.oauth.domain.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.application.dto.OauthParameter;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.repository.OauthClientRepository;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.avocado.boot.starter.oauth.domain.service.IGrantService;
import com.avocado.boot.starter.security.bean.Authentication;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;

/**
 * @author ：qiaoliang
 */
@Component
public class AuthorizationCodeIGrantService implements IGrantService {

    private final OauthClientRepository oauthClientRepository;

    public AuthorizationCodeIGrantService(OauthClientRepository oauthClientRepository) {
        this.oauthClientRepository = oauthClientRepository;
    }

    @Override
    public Authentication grant(OauthParameter parameter) {
        // 获取客户端信息
        OauthClient oauthClient = oauthClientRepository.getById(parameter.getClientId());
        BusinessException.isNull(oauthClient,INVALID_CLIENT_ID_ERROR);
        // 校验秘钥
        oauthClient.checkClientSecret(parameter.getClientSecret());
        return new Authentication(oauthClient.getId());
    }

    @Override
    public GrantType getGrantType() {
        return GrantType.authorization_code;
    }
}

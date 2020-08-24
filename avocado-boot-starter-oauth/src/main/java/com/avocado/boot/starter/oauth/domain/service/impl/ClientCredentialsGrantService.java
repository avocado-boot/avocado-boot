package com.avocado.boot.starter.oauth.domain.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.application.command.cmd.OauthCommand;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.repository.IOauthClientRepository;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.avocado.boot.starter.oauth.domain.service.IGrantService;
import com.avocado.boot.starter.security.bean.Authentication;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;

/**
 * @author ：qiaoliang
 */
@Component
public class ClientCredentialsGrantService implements IGrantService {

    private final IOauthClientRepository oauthClientRepository;

    public ClientCredentialsGrantService(IOauthClientRepository oauthClientRepository) {
        this.oauthClientRepository = oauthClientRepository;
    }

    @Override
    public Authentication grant(OauthCommand parameter) {
        // 获取客户端信息
        OauthClient oauthClient = oauthClientRepository.selectByClientIdAndGrantType(parameter.getClientId()
                ,parameter.getGrantType());
        BusinessException.isNull(oauthClient,INVALID_CLIENT_ID_ERROR);
        // 校验秘钥
        oauthClient.checkClientSecret(parameter.getClientSecret());
        return new Authentication(null,oauthClient.getExpiresIn());
    }
    @Override
    public GrantType getGrantType() {
        return GrantType.client_credentials;
    }
}

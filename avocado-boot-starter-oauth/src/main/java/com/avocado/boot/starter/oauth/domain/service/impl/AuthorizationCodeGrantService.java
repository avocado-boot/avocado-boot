package com.avocado.boot.starter.oauth.domain.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.application.command.cmd.OauthCommand;
import com.avocado.boot.starter.oauth.domain.GrantCode;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.service.IGrantCodeService;
import com.avocado.boot.starter.oauth.domain.service.IGrantService;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.avocado.boot.starter.security.bean.Authentication;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.NON_EMPTY_CODE_ERROR;

/**
 * @author ：qiaoliang
 */
@Component
public class AuthorizationCodeGrantService implements IGrantService {

    private final IGrantCodeService grantCodeService;

    public AuthorizationCodeGrantService(IGrantCodeService grantCodeService) {
        this.grantCodeService = grantCodeService;
    }

    @Override
    public Authentication grant(OauthCommand parameter) {
        //  校验授权码是否为空
        BusinessException.isNull(parameter.getCode(),NON_EMPTY_CODE_ERROR);
        //  获取授权码详细信息
        GrantCode grantCode = grantCodeService.selectByCode(parameter.getCode());
        //  校验客户端Id
        OauthClient client = grantCode.getClient();
        client.checkClientId(parameter.getClientId());
        //  校验客户端秘钥
        client.checkClientSecret(parameter.getClientSecret());
        return new Authentication(grantCode.getUserId(),client.getExpiresIn());
    }

    @Override
    public GrantType getGrantType() {
        return GrantType.authorization_code;
    }
}

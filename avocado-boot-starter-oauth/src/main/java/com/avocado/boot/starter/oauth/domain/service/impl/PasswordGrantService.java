package com.avocado.boot.starter.oauth.domain.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.application.command.cmd.OauthCommand;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.UserDetails;
import com.avocado.boot.starter.oauth.domain.repository.IOauthClientRepository;
import com.avocado.boot.starter.oauth.domain.service.IUserDetailsService;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.avocado.boot.starter.oauth.domain.service.IGrantService;
import com.avocado.boot.starter.security.bean.Authentication;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;
import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.NON_CREDENTIALS_EXPIRED_ERROR;
import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.NON_ENABLE_ERROR;
import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.NON_EXPIRED_ERROR;
import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.NON_LOCKED_ERROR;

/**
 * @author ：qiaoliang
 */
@Component
public class PasswordGrantService implements IGrantService {

    private final IUserDetailsService userDetailsService;
    private final IOauthClientRepository oauthClientRepository;

    public PasswordGrantService(IUserDetailsService userDetailsService,
                                IOauthClientRepository oauthClientRepository) {
        this.userDetailsService = userDetailsService;
        this.oauthClientRepository = oauthClientRepository;
    }

    @Override
    public Authentication grant(OauthCommand parameter) {
        // 校验客户端信息
        OauthClient oauthClient = oauthClientRepository.selectByClientIdAndGrantType(parameter.getClientId()
                ,parameter.getGrantType());
        BusinessException.isNull(oauthClient,INVALID_CLIENT_ID_ERROR);
        oauthClient.checkClientId(parameter.getClientId());
        oauthClient.checkClientSecret(parameter.getClientSecret());

        // 校验用户信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(parameter.getUsername());
        userDetails.checkPwd(parameter.getPassword());
        BusinessException.isFalse(userDetails.isEnabled(),NON_ENABLE_ERROR);
        BusinessException.isFalse(userDetails.isAccountNonExpired(),NON_EXPIRED_ERROR);
        BusinessException.isFalse(userDetails.isAccountNonLocked(),NON_LOCKED_ERROR);
        BusinessException.isFalse(userDetails.isCredentialsNonExpired(),NON_CREDENTIALS_EXPIRED_ERROR);
        return new Authentication(userDetails.getUserId(),userDetails.getAuthorities(),oauthClient.getExpiresIn());
    }

    @Override
    public GrantType getGrantType() {
        return GrantType.password;
    }

}

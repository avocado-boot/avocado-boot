package com.avocado.boot.starter.oauth.application.command;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.application.command.cmd.OauthCommand;
import com.avocado.boot.starter.oauth.domain.GrantFactory;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.repository.IOauthClientRepository;
import com.avocado.boot.starter.oauth.domain.service.IGrantCodeService;
import com.avocado.boot.starter.security.bean.AccessToken;
import com.avocado.boot.starter.security.bean.Authentication;
import com.avocado.boot.starter.security.context.SecurityContextHolder;
import com.avocado.boot.starter.security.service.ISecurityService;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;

/**
 * @author ：qiaoliang
 */
@Component
public class OauthClientCmd {

    private final ISecurityService securityService;
    private final IGrantCodeService grantCodeService;
    private final GrantFactory grantFactory;
    private final IOauthClientRepository oauthClientRepository;

    public OauthClientCmd(ISecurityService securityService,
                          IGrantCodeService grantCodeService,
                          GrantFactory grantFactory,
                          IOauthClientRepository oauthClientRepository) {
        this.securityService = securityService;
        this.grantCodeService = grantCodeService;
        this.grantFactory = grantFactory;
        this.oauthClientRepository = oauthClientRepository;
    }

    /**
     * 获取access_token
     *
     * @author ：qiaoliang
     * @param oauthCommand : 请求参数
     * @return com.avocado.boot.starter.security.bean.AccessToken
     */
    public AccessToken getAccessToken(OauthCommand oauthCommand){
        Authentication authentication = grantFactory.getInterface(oauthCommand.getGrantType()).grant(oauthCommand);
        return securityService.generateToken(authentication);
    }

    /**
     * 获取code
     *
     * @author ：qiaoliang
     * @param parameter : 请求参数
     * @return java.lang.String
     */
    public String getCode(OauthCommand parameter){
        // 获取客户端信息
        OauthClient oauthClient = oauthClientRepository.selectByClientIdAndGrantType(parameter.getClientId()
                ,parameter.getGrantType());
        BusinessException.isNull(oauthClient,INVALID_CLIENT_ID_ERROR);
        // 校验秘钥
        oauthClient.checkClientSecret(parameter.getClientSecret());
        return this.grantCodeService.generateCode(SecurityContextHolder.getAuthentication().getId()
                ,oauthClient).getCode();
    }

}

package com.avocado.boot.starter.oauth.application;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.application.dto.OauthParameter;
import com.avocado.boot.starter.oauth.domain.GrantFactory;
import com.avocado.boot.starter.oauth.domain.OauthClient;
import com.avocado.boot.starter.oauth.domain.repository.IOauthClientRepository;
import com.avocado.boot.starter.oauth.domain.service.IGrantCodeService;
import com.avocado.boot.starter.security.bean.AccessToken;
import com.avocado.boot.starter.security.bean.Authentication;
import com.avocado.boot.starter.security.context.SecurityContextHolder;
import com.avocado.boot.starter.security.service.ISecurityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.INVALID_CLIENT_ID_ERROR;

/**
 * @author ：qiaoliang
 */
@Component
public class OauthLoginManager {

    @Resource
    @Qualifier(value = "defaultSecurityService")
    private ISecurityService securityService;
    private final IGrantCodeService grantCodeService;
    private final GrantFactory grantFactory;
    private final IOauthClientRepository oauthClientRepository;

    public OauthLoginManager(IGrantCodeService grantCodeService,
                             GrantFactory grantFactory,
                             IOauthClientRepository oauthClientRepository) {
        this.grantCodeService = grantCodeService;
        this.grantFactory = grantFactory;
        this.oauthClientRepository = oauthClientRepository;
    }

    /**
     * 获取access_token
     *
     * @author ：qiaoliang
     * @param oauthParameter : 请求参数
     * @return com.avocado.boot.starter.security.bean.AccessToken
     */
    public AccessToken getAccessToken(OauthParameter oauthParameter) throws JsonProcessingException {
        Authentication grant = grantFactory.getInterface(oauthParameter.getGrantType()).grant(oauthParameter);
        return securityService.generateToken(grant);
    }


    /**
     * 获取code
     *
     * @author ：qiaoliang
     * @param parameter : 请求参数
     * @return java.lang.String
     * @date 2020-07-30 11:54
     */
    public String getCode(OauthParameter parameter){
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

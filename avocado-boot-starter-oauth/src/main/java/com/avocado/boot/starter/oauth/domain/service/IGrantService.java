package com.avocado.boot.starter.oauth.domain.service;

import com.avocado.boot.starter.oauth.application.command.cmd.OauthCommand;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import com.avocado.boot.starter.security.bean.Authentication;

/**
 *  认证接口
 *
 * @author ：qiaoliang
 */
public interface IGrantService {

    /**
     * 用户认证,认证通过则返回用户的凭证信息
     *
     * @author ：qiaoliang
     * @param parameter : 请求模型
     * @return com.avocado.boot.starter.security.bean.Authentication
     */
    Authentication grant(OauthCommand parameter);

    /**
     * 获取认证方式
     *
     * @author ：qiaoliang
     * @return com.avocado.boot.starter.oauth.infrastructure.enums.GrantType
     */
    GrantType getGrantType();

}

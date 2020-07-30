package com.avocado.boot.starter.oauth.domain.service;


import com.avocado.boot.starter.oauth.domain.GrantCode;
import com.avocado.boot.starter.oauth.domain.OauthClient;

/**
 * 授权码CRUD接口
 *
 * @author ：qiaoliang
 */
public interface IGrantCodeService {

    /**
     * 获取授权码信息
     *
     * @author ：qiaoliang
     * @param code : 授权码
     * @return com.avocado.boot.starter.oauth.domain.GrantCode
     * @date 2020-07-30 10:34
     */
    GrantCode selectByCode(String code);

    /**
     * 生成授权码
     *
     * @author ：qiaoliang
     * @param userId : 用户Id
     * @param client : Oauth客户端信息
     * @return com.avocado.boot.starter.oauth.domain.GrantCode
     * @date 2020-07-30 10:34
     */
    GrantCode generateCode(Long userId, OauthClient client);

}

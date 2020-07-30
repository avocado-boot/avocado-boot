package com.avocado.boot.starter.oauth.domain.service;

import com.avocado.boot.starter.oauth.domain.UserDetails;

/**
 * @author ：qiaoliang
 */
public interface IUserDetailsService {

    /**
     * 通过账号获取用户信息
     *
     * @author ：qiaoliang
     * @param username : 账号
     * @return com.avocado.boot.starter.oauth.domain.UserDetails
     * @date 2020-07-30 11:05
     */
    UserDetails loadUserByUsername(String username);

}

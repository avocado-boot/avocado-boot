package com.avocado.boot.starter.security.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 令牌存储策略
 *
 * @author ：qiaoliang
 */
public interface TokenStorage {

    String BEARER = "Bearer";

    /**
     * 从请求中获取访问令牌,默认从请求头中获取
     * @param request 请求对象
     * @return String
     */
    String getAccessToken(HttpServletRequest request);

}

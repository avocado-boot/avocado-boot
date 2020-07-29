package com.avocado.boot.starter.security.handler;

import cn.hutool.core.collection.CollUtil;
import com.avocado.boot.starter.security.bean.Authentication;
import com.avocado.boot.starter.security.context.SecurityContextHolder;
import com.avocado.boot.starter.security.service.ISecurityService;
import com.avocado.boot.starter.security.service.TokenStorage;
import com.avocado.boot.starter.security.support.InterceptorSupport;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 认证拦截器
 *
 * @author ：qiaoliang
 */
public class AuthenticationInterceptor implements InterceptorSupport {

    private final ISecurityService securityService;
    private final TokenStorage tokenStorage;
    private List<String> pathPatterns;
    private List<String> excludePathPatterns;

    public AuthenticationInterceptor(ISecurityService securityService,
                                     TokenStorage tokenStorage) {
        this.securityService = securityService;
        this.tokenStorage = tokenStorage;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //  获取访问令牌
        String accessToken = this.tokenStorage.getAccessToken(request);
        //  获取当前用户认证信息
        Authentication authentication = securityService.getAuthentication(accessToken);
        //  将用户认证信息存放在当前线程中
        SecurityContextHolder.set(authentication);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //  将当前线程中的用户信息清空
        SecurityContextHolder.clear();
    }

    public void pathPatterns(List<String> pathPatterns){
        this.pathPatterns = pathPatterns;
    }

    public void excludePathPatterns(List<String> excludePathPatterns){
        this.excludePathPatterns = excludePathPatterns;
    }

    @Override
    public List<String> getPathPatterns() {
        if(CollUtil.isNotEmpty(pathPatterns)){
            return pathPatterns;
        }
        return new ArrayList<>(Arrays.asList("","/**"));
    }

    @Override
    public List<String> excludePathPatterns() {
        if(CollUtil.isNotEmpty(excludePathPatterns)){
            return excludePathPatterns;
        }
        return new ArrayList<>();
    }
}
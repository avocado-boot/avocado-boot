package com.avocado.boot.starter.security.handler;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.core.support.InterceptorSupport;
import com.avocado.boot.starter.security.bean.Authentication;
import com.avocado.boot.starter.security.context.SecurityContextHolder;
import com.avocado.boot.starter.security.service.ISecurityService;
import com.avocado.boot.starter.security.service.TokenStorage;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 认证拦截器
 *
 * @author ：qiaoliang
 */
public class AuthenticationInterceptor implements InterceptorSupport {

    private final ISecurityService securityService;
    private final TokenStorage tokenStorage;
    private final List<String> pathPatterns = Collections.singletonList("/**");
    private final List<String> exclude = new ArrayList<>();

    public AuthenticationInterceptor(ISecurityService securityService,
                                     TokenStorage tokenStorage) {
        this.securityService = securityService;
        this.tokenStorage = tokenStorage;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            //  获取访问令牌
            String accessToken = this.tokenStorage.getAccessToken(request);
            //  获取当前用户认证信息
            Authentication authentication = securityService.getAuthentication(accessToken);
            //  将用户认证信息存放在当前线程中
            SecurityContextHolder.set(authentication);
        }catch (BusinessException e){
            response.setStatus(e.getErrorType().getCode());
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(e.getMessage());
            response.getWriter().flush();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //  将当前线程中的用户信息清空
        SecurityContextHolder.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void addExcludePathPatterns(String... excludePathPatterns){
        if(Objects.nonNull(excludePathPatterns)){
            this.exclude.addAll(Arrays.asList(excludePathPatterns));
        }
    }

    @Override
    public List<String> getPathPatterns() {
        return pathPatterns;
    }

    @Override
    public List<String> excludePathPatterns() {
        exclude.addAll(Arrays.asList("/doc.html",
                "/swagger-resources/**",
                "/swagger/**",
                "/v2/api-docs/**",
                "/webjars/**",
                "/oauth/token"));
        return exclude;
    }

}

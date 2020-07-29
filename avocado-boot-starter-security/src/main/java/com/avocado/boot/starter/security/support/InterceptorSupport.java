package com.avocado.boot.starter.security.support;

import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

/**
 *
 * @author ：qiaoliang
 */
public interface InterceptorSupport extends HandlerInterceptor {

    /**
     * 拦截路径匹配规则
     *
     * @author ：qiaoliang
     * @return java.util.List<java.lang.String>
     */
    List<String> getPathPatterns();

    /**
     * 不拦截路径匹配规则
     *
     * @author ：qiaoliang
     * @return java.util.List<java.lang.String>
     */
    List<String> excludePathPatterns();

}

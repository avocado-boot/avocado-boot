package com.avocado.boot.starter.security.handler;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.security.annotation.PreAuthorize;
import com.avocado.boot.starter.security.bean.Authentication;
import com.avocado.boot.starter.security.context.SecurityContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import static com.avocado.boot.starter.security.enums.SecurityErrorType.ACCESS_DENIED_EXCEPTION;

/**
 * 授权程序处理器
 *
 * @author ：qiaoliang
 */
@Aspect
public class AuthorizeAspectHandler {

    @Before(value = "@annotation(preAuthorize)")
    public void before(PreAuthorize preAuthorize){
        //  获取当前用户认证信息
        Authentication authentication = SecurityContextHolder.getAuthentication();
        //  权限校验
        if (preAuthorize.value().length > 0){
            BusinessException.isFalse(authentication.getAuthorities().stream()
                    .filter(StringUtils::hasText)
                    .anyMatch(x -> PatternMatchUtils.simpleMatch(preAuthorize.value(), x)),ACCESS_DENIED_EXCEPTION);
        }
    }
}

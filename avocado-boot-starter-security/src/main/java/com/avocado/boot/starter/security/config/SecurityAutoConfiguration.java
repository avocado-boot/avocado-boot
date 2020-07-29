package com.avocado.boot.starter.security.config;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.security.handler.AuthenticationInterceptor;
import com.avocado.boot.starter.security.handler.AuthorizeAspectHandler;
import com.avocado.boot.starter.security.properties.SecurityProperties;
import com.avocado.boot.starter.security.service.ISecurityService;
import com.avocado.boot.starter.security.service.TokenStorage;
import com.avocado.boot.starter.security.service.impl.DefaultSecurityService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import static com.avocado.boot.starter.security.enums.SecurityErrorType.NO_ACCESS_ERROR;

/**
 * @author ：qiaoliang
 */

@EnableConfigurationProperties({SecurityProperties.class})
@Import(AuthorizeAspectHandler.class)
@Configuration
public class SecurityAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public ISecurityService securityService(SecurityProperties securityProperties){
        return new DefaultSecurityService(securityProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenStorage tokenStorage(){
        return (request) -> {
            //  从请求头中获取令牌
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (StringUtils.isEmpty(token)){
                //  未获取到令牌,则直接报401错误
                throw new BusinessException(NO_ACCESS_ERROR);
            }
            //  截取访问令牌
            return token.replace(TokenStorage.BEARER,"").trim();
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationInterceptor authenticationInterceptor(ISecurityService securityService,
                                                               TokenStorage tokenStorage){
        return new AuthenticationInterceptor(securityService,tokenStorage);
    }

}

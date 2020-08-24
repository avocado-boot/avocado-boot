package com.avocado.boot.starter.security.config;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.security.handler.AuthenticationInterceptor;
import com.avocado.boot.starter.security.handler.AuthorizeAspectHandler;
import com.avocado.boot.starter.security.properties.SecurityProperties;
import com.avocado.boot.starter.security.service.ISecurityService;
import com.avocado.boot.starter.security.service.TokenStorage;
import com.avocado.boot.starter.security.service.impl.RedisSecurityService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan("com.avocado.boot.starter.security.service")
@Configuration
public class SecurityAutoConfiguration {

    private SecurityProperties securityProperties;

    public SecurityAutoConfiguration(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenStorage tokenStorage(){
        return (request) -> {
            //  从请求头中获取令牌
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            //  未获取到令牌,则直接报401错误
            BusinessException.isTrue(StringUtils.isEmpty(token),NO_ACCESS_ERROR);
            //  截取访问令牌
            return token.replace(TokenStorage.BEARER,"").trim();
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationInterceptor authenticationInterceptor(ISecurityService securityService,
                                                               TokenStorage tokenStorage){
        AuthenticationInterceptor authenticationInterceptor =
                new AuthenticationInterceptor(securityService, tokenStorage);
        authenticationInterceptor.addExcludePathPatterns(securityProperties.getExclude());
        return authenticationInterceptor;
    }

    @Bean
    @ConditionalOnMissingBean
    public ISecurityService securityService(){
        return new RedisSecurityService();
    }

}

package com.avocado.boot.starter.oauth.infrastructure.config;

import com.avocado.boot.starter.oauth.domain.service.impl.UserDetailsService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：qiaoliang
 */
@Configuration
@MapperScan("com.avocado.boot.starter.oauth.infrastructure.mapper")
@ComponentScan(basePackages = {
        "com.avocado.boot.starter.oauth.domain",
        "com.avocado.boot.starter.oauth.application",
        "com.avocado.boot.starter.oauth.controller",
        "com.avocado.boot.starter.oauth.infrastructure.repository",
})
public class OauthConfig {

    @Bean
    @ConditionalOnMissingBean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService();
    }

}

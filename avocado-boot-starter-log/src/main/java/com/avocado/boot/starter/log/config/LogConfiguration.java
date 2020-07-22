package com.avocado.boot.starter.log.config;

import com.avocado.boot.starter.log.annotation.LogConfigurerSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：qiaoliang
 * @date ：2020-07-22
 */
@ComponentScan(basePackages = {
        "com.avocado.boot.starter.log.service",
        "com.avocado.boot.starter.log.aop",
        "com.avocado.boot.starter.log.factory"
})
@Configuration
public class LogConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LogConfigurerSupport toLogConfigurerSupport(){
        return new LogConfigurerSupport();
    }

}

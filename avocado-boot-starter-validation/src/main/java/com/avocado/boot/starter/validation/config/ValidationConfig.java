package com.avocado.boot.starter.validation.config;

import com.avocado.boot.starter.validation.handler.ExceptionAdviceHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：qiaoliang
 */
@Configuration
public class ValidationConfig {

    @Bean
    @ConditionalOnMissingBean
    public ExceptionAdviceHandler getExceptionAdviceHandler(){
        return new ExceptionAdviceHandler();
    }

}

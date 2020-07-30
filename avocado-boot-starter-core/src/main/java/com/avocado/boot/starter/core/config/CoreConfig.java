package com.avocado.boot.starter.core.config;

import com.avocado.boot.starter.core.handler.ExceptionAdviceHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：qiaoliang
 * @date ：2020-07-30
 */
@Configuration
public class CoreConfig {

    @Bean
    @ConditionalOnMissingBean
    public ExceptionAdviceHandler getExceptionAdviceHandler(){
        return new ExceptionAdviceHandler();
    }

}

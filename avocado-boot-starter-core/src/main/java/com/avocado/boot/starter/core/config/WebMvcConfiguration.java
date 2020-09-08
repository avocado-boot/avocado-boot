package com.avocado.boot.starter.core.config;

import com.avocado.boot.starter.core.handler.ExceptionAdviceHandler;
import com.avocado.boot.starter.core.support.InterceptorSupport;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collection;

/**
 * Web配置
 *
 * @author ：qiaoliang
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    /**
     * 拦截器列表
     */
    private Collection<InterceptorSupport> interceptors = null;

    /**
     * 注册拦截器
     *
     * @author ：qiaoliang
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        interceptors.forEach(interceptor -> registry.addInterceptor(interceptor)
                .addPathPatterns(interceptor.getPathPatterns())
        .excludePathPatterns(interceptor.excludePathPatterns()));
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
        //  从容器中获取拦截器
        this.interceptors = context.getBeansOfType(InterceptorSupport.class).values();
    }

    @Bean
    @ConditionalOnMissingBean
    public ExceptionAdviceHandler getExceptionAdviceHandler(){
        return new ExceptionAdviceHandler();
    }

}

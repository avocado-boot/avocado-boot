package com.avocado.boot.starter.mybatis.config;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：qiaoliang
 * @date ：2020-07-21
 */
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfiguration {

    /**
     * 分页插件
     *
     * @author ：qiaoliang

     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @date 2020-07-21 16:49
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor().setOverflow(true);
    }

    /**
     * 默认配置
     *
     * @author ：qiaoliang

     * @return com.avocado.boot.starter.mybatis.config.ModelMetaObjectHandler
     * @date 2020-07-21 16:50
     */
    @Bean
    public ModelMetaObjectHandler modelMetaObjectHandler(){
        return new ModelMetaObjectHandler();
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new DefaultSqlInjector();
    }

}

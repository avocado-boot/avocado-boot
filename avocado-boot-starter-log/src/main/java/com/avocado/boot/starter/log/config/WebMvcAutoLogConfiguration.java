package com.avocado.boot.starter.log.config;

import com.avocado.boot.starter.log.aop.LogAspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author ：qiaoliang
 * @date ：2020-07-16
 */
@ComponentScan(basePackages = {
        "com.avocado.boot.starter.log.service",
        "com.avocado.boot.starter.log.factory"
})
@Import({LogAspect.class})
public class WebMvcAutoLogConfiguration{

}

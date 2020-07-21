package com.avocado.boot.starter.log.config;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.log.Logs;
import com.avocado.boot.starter.log.annotation.LogConfigurerSupport;
import com.avocado.boot.starter.log.enums.LogLevelType;
import com.avocado.boot.starter.log.factory.LogConfigurationAdapter;
import com.avocado.boot.starter.log.invalid.ControllerLog;
import com.avocado.boot.starter.log.properties.LogProperties;
import com.avocado.boot.starter.log.service.LogOutput;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author ：qiaoliang
 * @date ：2020-07-16
 */
@ComponentScan(basePackages = {
        "com.avocado.boot.starter.log.service",
        "com.avocado.boot.starter.log.factory"
})
@Aspect
@EnableConfigurationProperties({LogProperties.class})
@ConditionalOnProperty(prefix = "avocado.log", name = "enabled", havingValue = "true",matchIfMissing = true)
public class LogAspectConfiguration {

    private final LogConfigurerSupport logConfigurerSupport;
    private final LogOutput logOutput;
    private Logs logs = null;

    public LogAspectConfiguration(LogConfigurerSupport logConfigurerSupport,
                                  LogConfigurationAdapter logConfigurationAdapter,
                                  LogProperties logProperties) {
        this.logOutput = logConfigurationAdapter.getLogConfiguration
                (LogLevelType.valueOf(logProperties.getLevel()));
        this.logConfigurerSupport = logConfigurerSupport;
    }

    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.avocado.boot.starter.log.invalid.ControllerLog)")
    public void controllerAspect(){
    }

    /**
     * 方法调用前触发
     *
     * @author qiaoliang
     * @date 2020-04-16 13:40
     */
    @Before(value = "controllerAspect()")
    public void before(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if(Objects.nonNull(attributes)){
            request = attributes.getRequest();
        }
        logs = new Logs();
        logs.setMethodName(getAnnotation(joinPoint).discription());
        logs.beforeCalling(request,joinPoint);
        logOutput.before(logs);
        logConfigurerSupport.before(logs);
    }


    /**
     * 方法调用后触发
     *
     * @author qiaoliang
     * @date 2020-04-16 13:43
     */
    @AfterReturning(returning = "ret", pointcut = "controllerAspect()")
    public void doAfterReturning(Object ret) {
        logs.doAfterReturning(ret);
        logOutput.doAfterReturning(logs);
        logConfigurerSupport.doAfterReturning(logs);
    }


    /**
     * 异常通知：
     * 1. 在目标方法非正常结束，发生异常或者抛出异常时执行
     * 1. 在异常通知中设置异常信息，并将其保存
     *
     * @param exception
     */
    @AfterThrowing(value = "controllerAspect()", throwing = "exception")
    public void doAfterThrowing(Exception exception) {
        logs.doAfterThrowing(exception);
        if(exception instanceof BusinessException){
            logOutput.businessLog(logs);
        }else {
            logOutput.doAfterThrowing(logs);
        }
        logConfigurerSupport.doAfterThrowing(logs);
    }


    private ControllerLog getAnnotation(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //得到目标方法
        Method method = signature.getMethod();
        //得到方法之上的注解
        return method.getAnnotation(ControllerLog.class);
    }



}
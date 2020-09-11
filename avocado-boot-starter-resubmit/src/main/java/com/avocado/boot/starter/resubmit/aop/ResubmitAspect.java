package com.avocado.boot.starter.resubmit.aop;


import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Method;
import java.util.Objects;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.core.support.IOperatorService;
import com.avocado.boot.starter.redis.utils.RedisUtil;
import com.avocado.boot.starter.resubmit.invalid.ResubmitAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * 重复提交切面
 *
 * @author ：qiaoliang
 * @date ：2020-09-11
 */
@Aspect
@Component
public class ResubmitAspect {

    /**重复提交验证缓存规则key**/
    public static final String INTEGRAL_RESUBMIT_USER_KEY = "resubmit:user:";

    private final IOperatorService operatorService;

    public ResubmitAspect(IOperatorService operatorService) {
        this.operatorService = operatorService;
    }


    @Pointcut("@annotation(com.avocado.boot.starter.resubmit.invalid.ResubmitAnnotation)")
    public void resubmit(){}

    /**
     * 方法执行前
     */
    @Before(value = "resubmit()")
    public void before(JoinPoint joinPoint){
        String currentUserId = (String) operatorService.operator();
        if(StrUtil.isNotBlank(currentUserId)){
            ResubmitAnnotation annotation = getAnnotation(joinPoint);
            String key = INTEGRAL_RESUBMIT_USER_KEY + annotation.businessType() + ":" + currentUserId;
            Object createByRedis = RedisUtil.get(key);
            if(Objects.nonNull(createByRedis)){
                throw new BusinessException(annotation.errorMessage());
            }else {
                RedisUtil.set(key,annotation.resubmitTime(),currentUserId);
            }
        }
    }

    /**
     * 方法执行结束，不管是抛出异常或者正常退出都会执行
     */
    @After(value = "resubmit()")
    public void after(JoinPoint joinPoint){
        String currentUserId = (String) operatorService.operator();
        if(StrUtil.isNotBlank(currentUserId)){
            ResubmitAnnotation annotation = getAnnotation(joinPoint);
            String key = INTEGRAL_RESUBMIT_USER_KEY + annotation.businessType() + ":" + currentUserId;
            RedisUtil.delete(key);
        }
    }

    private ResubmitAnnotation getAnnotation(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //得到目标方法
        Method method = signature.getMethod();
        //得到方法之上的注解
        return method.getAnnotation(ResubmitAnnotation.class);
    }

}

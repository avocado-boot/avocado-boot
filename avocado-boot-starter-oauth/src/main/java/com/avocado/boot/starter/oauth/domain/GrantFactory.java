package com.avocado.boot.starter.oauth.domain;

import com.avocado.boot.starter.oauth.domain.service.IGrantService;
import com.avocado.boot.starter.oauth.infrastructure.enums.GrantType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证工厂
 *
 * @author ：qiaoliang
 */
@Component
public class GrantFactory  implements ApplicationContextAware {

    private static Map<GrantType, IGrantService> GRANT_SERVICE_MAP;

    /**
     * 根据认证方式获取相应的认证接口
     *
     * @author ：qiaoliang
     * @param grantType : 认证方式
     * @return com.avocado.boot.starter.oauth.domain.service.IGrantService
     */
    public IGrantService getInterface(GrantType grantType){
        return GRANT_SERVICE_MAP.get(grantType);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IGrantService> beanMap = applicationContext.getBeansOfType(IGrantService.class);
        GRANT_SERVICE_MAP = new HashMap<>(beanMap.size());
        beanMap.forEach((beanName,bean) -> GRANT_SERVICE_MAP.put(bean.getGrantType(),bean));
    }
}

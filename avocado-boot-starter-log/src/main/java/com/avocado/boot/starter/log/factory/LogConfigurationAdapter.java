package com.avocado.boot.starter.log.factory;

import com.avocado.boot.starter.log.enums.LogLevelType;
import com.avocado.boot.starter.log.service.LogOutput;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志工厂
 *
 * @author ：qiaoliang
 */
public class LogConfigurationAdapter implements ApplicationContextAware,LogConfigurerComposite {

    private static Map<LogLevelType, LogOutput> LOG_MAP;

    @Override
    public LogOutput getLogConfiguration(LogLevelType type) {
        return LOG_MAP.get(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, LogOutput> beansOfType = applicationContext.getBeansOfType(
                LogOutput.class);
        LOG_MAP = new HashMap<>(beansOfType.size());
        beansOfType.forEach((k,v)->LOG_MAP.put(v.getFlag(),v));
    }

}

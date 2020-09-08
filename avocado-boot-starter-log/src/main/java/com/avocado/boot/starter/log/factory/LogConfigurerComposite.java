package com.avocado.boot.starter.log.factory;

import com.avocado.boot.starter.log.enums.LogLevelType;
import com.avocado.boot.starter.log.service.LogOutput;

/**
 * 工厂接口
 *
 * @author ：qiaoliang
 */
public interface LogConfigurerComposite {

    LogOutput getLogConfiguration(LogLevelType type);

}

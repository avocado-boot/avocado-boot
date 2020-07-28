package com.avocado.boot.starter.log.factory;

import com.avocado.boot.starter.log.service.LogOutput;
import com.avocado.boot.starter.log.enums.LogLevelType;

/**
 * 工厂接口
 *
 * @author ：qiaoliang
 */
public interface LogConfigurerComposite {

    LogOutput getLogConfiguration(LogLevelType type);

}

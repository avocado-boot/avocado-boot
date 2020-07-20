package com.avocado.boot.starter.log.factory;

import com.avocado.boot.starter.log.service.LogOutput;
import com.avocado.boot.starter.log.enums.LogLevelType;

/**
 * @author ：qiaoliang
 * @date ：2020-07-16
 */
public interface LogConfigurerComposite {

    LogOutput getLogConfiguration(LogLevelType type);

}

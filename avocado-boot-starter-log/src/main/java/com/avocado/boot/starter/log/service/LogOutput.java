package com.avocado.boot.starter.log.service;

import com.avocado.boot.starter.log.Logs;
import com.avocado.boot.starter.log.LogConfigurer;
import com.avocado.boot.starter.log.enums.LogLevelType;

/**
 * @author ：qiaoliang
 */
public interface LogOutput extends LogConfigurer {

    /**
     * 自定义异常输出
     *
     * @author ：qiaoliang
     * @param logs : 日志信息
     */
    void businessLog(Logs logs);

    /**
     * 实现方式的唯一标识
     *
     * @author ：qiaoliang
     * @return com.sandwind.cloud.common.core.enums.LogLevelType
     */
    LogLevelType getFlag();

}

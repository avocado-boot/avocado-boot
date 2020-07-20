package com.avocado.boot.starter.log.service;

import com.avocado.boot.starter.log.Logs;
import com.avocado.boot.starter.log.annotation.LogConfigurer;
import com.avocado.boot.starter.log.enums.LogLevelType;

/**
 * @author ：qiaoliang
 * @date ：2020-07-16
 */
public interface LogOutput extends LogConfigurer {

    /**
     * 自定义异常输出
     *
     * @author ：qiaoliang
     * @param logs :
     * @return void
     * @date 2020-07-16 17:44
     */
    void businessLog(Logs logs);

    /**
     * 实现方式的唯一标识
     *
     * @author ：qiaoliang

     * @return com.sandwind.cloud.common.core.enums.LogLevelType
     * @date 2020-07-10 10:48
     */
    LogLevelType getFlag();

}

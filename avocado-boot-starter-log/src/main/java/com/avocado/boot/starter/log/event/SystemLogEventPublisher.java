package com.avocado.boot.starter.log.event;

import com.avocado.boot.starter.core.bus.listeners.AbstractGuavaDomainEventPublisher;

/**
 * @author ：qiaoliang
 * @date ：2020-07-30
 */
public class SystemLogEventPublisher extends AbstractGuavaDomainEventPublisher {
    @Override
    public String identify() {
        return "system_log_event";
    }
}

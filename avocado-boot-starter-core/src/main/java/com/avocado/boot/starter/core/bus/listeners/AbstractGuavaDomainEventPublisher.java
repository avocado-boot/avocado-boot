package com.avocado.boot.starter.core.bus.listeners;

import com.avocado.boot.starter.core.bus.event.AbstractDomainEvent;
import com.avocado.boot.starter.core.bus.listeners.DomainEventPublisher;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Guava事件发布器实现
 *
 * @author ：qiaoliang
 * @date ：2020-06-27
 */
public abstract class AbstractGuavaDomainEventPublisher implements DomainEventPublisher {

    private EventBus syncBus = new EventBus(identify());

    private EventBus asyncBus = new AsyncEventBus(identify(),
            new ScheduledThreadPoolExecutor(1,
                    new BasicThreadFactory.Builder().daemon(true).build()));

    @Override
    public void register(Object listener) {
        syncBus.register(listener);
        asyncBus.register(listener);
    }

    @Override
    public void publish(AbstractDomainEvent event) {
        syncBus.post(event);
    }

    @Override
    public void asyncPublish(AbstractDomainEvent event) {
        asyncBus.post(event);
    }

}

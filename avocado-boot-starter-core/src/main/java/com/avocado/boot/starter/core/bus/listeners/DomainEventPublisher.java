package com.avocado.boot.starter.core.bus.listeners;

import com.avocado.boot.starter.core.bus.event.AbstractDomainEvent;

/**
 * 触发接口限制
 *
 * @author ：qiaoliang
 */
public interface DomainEventPublisher<T extends AbstractDomainEvent> {

    String identify();

    /**
     * 注册
     *
     * @author ：qiaoliang
     * @param listener : 监听
     */
    void register(Object listener);

    /**
     * 同步消息
     *
     * @author ：qiaoliang
     * @param event : 消息模型
     */
    void publish(T event);
    /**
     * 异步消息
     *
     * @author ：qiaoliang
     * @param event : 消息模型
     */
    void asyncPublish(T event);

}

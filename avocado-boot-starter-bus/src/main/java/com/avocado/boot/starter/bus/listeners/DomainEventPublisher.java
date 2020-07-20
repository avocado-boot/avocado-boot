package com.avocado.boot.starter.bus.listeners;

import com.avocado.boot.starter.bus.event.AbstractDomainEvent;

/**
 * 触发接口限制
 *
 * @author ：qiaoliang
 * @date ：2020-06-27
 */
public interface DomainEventPublisher<T extends AbstractDomainEvent> {

    String identify();

    /**
     * 注册
     *
     * @author ：qiaoliang
     * @param listener : 监听
     * @date 2020-06-27 11:30
     */
    void register(Object listener);

    /**
     * 同步消息
     *
     * @author ：qiaoliang
     * @param event : 消息模型
     * @date 2020-06-27 11:30
     */
    void publish(T event);
    /**
     * 异步消息
     *
     * @author ：qiaoliang
     * @param event : 消息模型
     * @date 2020-06-27 11:30
     */
    void asyncPublish(T event);

}

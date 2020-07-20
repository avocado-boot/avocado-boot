package com.avocado.boot.starter.bus.event;

import java.util.Date;

/**
 * @author ：qiaoliang
 * @date ：2020-06-27
 */
public class AbstractDomainEvent {
    /**
     * 创建时间
     **/
    private final Date curredTime;

    public AbstractDomainEvent() {
        this.curredTime = new Date();
    }

    public Date getCurredTime() {
        return curredTime;
    }
}

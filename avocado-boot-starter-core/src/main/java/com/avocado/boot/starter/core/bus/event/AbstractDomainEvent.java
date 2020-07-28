package com.avocado.boot.starter.core.bus.event;

import java.util.Date;

/**
 * @author ：qiaoliang
 */
public class AbstractDomainEvent {
    /**创建时间**/
    private final Date curredTime;

    public AbstractDomainEvent() {
        this.curredTime = new Date();
    }

    public Date getCurredTime() {
        return curredTime;
    }
}

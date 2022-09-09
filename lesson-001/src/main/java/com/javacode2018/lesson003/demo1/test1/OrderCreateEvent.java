package com.javacode2018.lesson003.demo1.test1;

import org.springframework.context.ApplicationEvent;

/**
 * 订单创建事件
 */
public class OrderCreateEvent extends ApplicationEvent {
    //订单id
    private Long orderId;

    /**
     * @param source  事件源
     * @param orderId 订单id
     */
    public OrderCreateEvent(Object source, Long orderId) {
        super(source);
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}

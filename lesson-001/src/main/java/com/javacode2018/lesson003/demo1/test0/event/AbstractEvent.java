package com.javacode2018.lesson003.demo1.test0.event;

/**
 * 事件对象
 */
public abstract class AbstractEvent {

    //事件源
    protected Object source;

    public AbstractEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}

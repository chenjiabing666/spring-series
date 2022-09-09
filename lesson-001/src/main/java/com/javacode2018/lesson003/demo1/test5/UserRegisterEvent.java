package com.javacode2018.lesson003.demo1.test5;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件
 */
public class UserRegisterEvent extends ApplicationEvent {
    //用户名
    private String userName;

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

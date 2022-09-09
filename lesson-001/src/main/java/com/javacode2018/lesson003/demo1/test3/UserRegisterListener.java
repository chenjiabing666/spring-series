package com.javacode2018.lesson003.demo1.test3;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册监听器
 */
@Component
public class UserRegisterListener {
    @EventListener
    public void sendMail(UserRegisterEvent event) {
        System.out.println(String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
    }

    @EventListener
    public void sendCompon(UserRegisterEvent event) {
        System.out.println(String.format("给用户【%s】发送优惠券!", event.getUserName()));
    }
}

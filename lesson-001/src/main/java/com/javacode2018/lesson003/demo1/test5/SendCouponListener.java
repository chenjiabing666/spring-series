package com.javacode2018.lesson003.demo1.test5;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 给用户各种优惠券
 */
@Component
public class SendCouponListener {
    @EventListener
    public void onApplicationEvent(UserRegisterEvent event) throws InterruptedException {
        System.out.println(
                String.format("当前线程【%s】,给用户【%s】发放一些优惠券!", Thread.currentThread(),
                        event.getUserName()));
    }
}

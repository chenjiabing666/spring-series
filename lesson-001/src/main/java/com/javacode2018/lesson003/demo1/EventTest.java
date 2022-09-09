package com.javacode2018.lesson003.demo1;

import com.javacode2018.lesson003.demo1.test0.userregister.MainConfig0;
import com.javacode2018.lesson003.demo1.test2.MainConfig2;
import com.javacode2018.lesson003.demo1.test3.MainConfig3;
import com.javacode2018.lesson003.demo1.test4.MainConfig4;
import com.javacode2018.lesson003.demo1.test5.MainConfig5;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventTest {

    @Test
    public void test0() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
        //获取用户注册服务
        com.javacode2018.lesson003.demo1.test0.userregister.UserRegisterService userRegisterService =
                context.getBean(com.javacode2018.lesson003.demo1.test0.userregister.UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("陈某Java");
    }

    @Test
    public void test2() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig2.class);
        context.refresh();
        //获取用户注册服务
        com.javacode2018.lesson003.demo1.test2.UserRegisterService userRegisterService =
                context.getBean(com.javacode2018.lesson003.demo1.test2.UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("陈某Java");
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig3.class);
        context.refresh();
        //获取用户注册服务
        com.javacode2018.lesson003.demo1.test3.UserRegisterService userRegisterService =
                context.getBean(com.javacode2018.lesson003.demo1.test3.UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("陈某Java");
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig4.class);
        context.refresh();
        //获取用户注册服务
        com.javacode2018.lesson003.demo1.test4.UserRegisterService userRegisterService =
                context.getBean(com.javacode2018.lesson003.demo1.test4.UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("陈某Java");
    }

    @Test
    public void test5() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig5.class);
        context.refresh();
        //获取用户注册服务
        com.javacode2018.lesson003.demo1.test5.UserRegisterService userRegisterService =
                context.getBean(com.javacode2018.lesson003.demo1.test5.UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("陈某Java");
    }

}

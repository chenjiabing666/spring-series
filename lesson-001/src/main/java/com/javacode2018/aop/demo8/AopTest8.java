package com.javacode2018.aop.demo8;

import com.javacode2018.aop.demo8.test1.MainConfig1;
import com.javacode2018.aop.demo8.test1.Service1;
import com.javacode2018.aop.demo8.test2.MainConfig2;
import com.javacode2018.aop.demo8.test3.MainConfig3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest8 {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        //获取代理对象，代理对象bean的名称为注册ProxyFactoryBean的名称，即：service1Proxy
        Service1 bean = context.getBean("service1Proxy", Service1.class);
        System.out.println("----------------------");
        //调用代理的方法
        bean.m1();
        System.out.println("----------------------");
        //调用代理的方法
        bean.m2();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        //获取代理对象，代理对象bean的名称为注册ProxyFactoryBean的名称，即：service1Proxy
        Service1 bean = context.getBean("service1Proxy", Service1.class);
        System.out.println("----------------------");
        //调用代理的方法
        bean.m1();
        System.out.println("----------------------");
        //调用代理的方法
        bean.m2();
    }

@Test
public void test3() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
    //获取代理对象，代理对象bean的名称为注册ProxyFactoryBean的名称，即：service1Proxy
    Service1 bean = context.getBean("service1Proxy", Service1.class);
    System.out.println("----------------------");
    //调用代理的方法
    bean.m1();
    System.out.println("----------------------");
    //调用代理的方法
    bean.m2();
}
}

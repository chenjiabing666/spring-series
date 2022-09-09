package com.javacode2018.aop.demo10;

import com.javacode2018.aop.demo10.test1.BeforeAspect1;
import com.javacode2018.aop.demo10.test1.Service1;
import com.javacode2018.aop.demo10.test2.BeforeAspect2;
import com.javacode2018.aop.demo10.test3.AroundAspect3;
import com.javacode2018.aop.demo10.test4.AfterAspect4;
import com.javacode2018.aop.demo10.test5.AfterReturningAspect5;
import com.javacode2018.aop.demo10.test6.AfterThrowingAspect6;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AopTest10 {

    @Test
    public void test1() {
        Service1 target = new Service1();
        Class<BeforeAspect1> aspectClass = BeforeAspect1.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("陈某"));
        System.out.println(proxy.work("陈某"));
    }

    @Test
    public void test2() {
        Service1 target = new Service1();
        Class<BeforeAspect2> aspectClass = BeforeAspect2.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("陈某"));
        System.out.println(proxy.work("陈某"));
    }

    @Test
    public void test3() {
        Service1 target = new Service1();
        Class<AroundAspect3> aspectClass = AroundAspect3.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("陈某"));
        System.out.println(proxy.work("陈某"));
    }

    @Test
    public void test4() {
        Service1 target = new Service1();
        Class<AfterAspect4> aspectClass = AfterAspect4.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("陈某"));
        System.out.println(proxy.work("陈某"));
    }

    @Test
    public void test5() {
        Service1 target = new Service1();
        Class<AfterReturningAspect5> aspectClass = AfterReturningAspect5.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("陈某"));
        System.out.println(proxy.work("陈某"));
    }

    @Test
    public void test6() {
        Service1 target = new Service1();
        Class<AfterThrowingAspect6> aspectClass = AfterThrowingAspect6.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        proxy.login("陈某");
    }






















    @Test
    public void test7(){
        System.out.println(Integer.class);
        System.out.println(Integer[].class);
        System.out.println(Integer[][].class);
        Class<Integer[][][]> x = Integer[][][].class;
        System.out.println(x);
    }
}

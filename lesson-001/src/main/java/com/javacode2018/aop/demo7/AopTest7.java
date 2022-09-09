package com.javacode2018.aop.demo7;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyFactory;

class Service {
    public void m1() {
        System.out.println("m1");
        ((Service) AopContext.currentProxy()).m2();
    }

    public void m2() {
        System.out.println("m2");
    }
}

public class AopTest7 {
    @Test
    public void test1() {
        Service target = new Service();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setExposeProxy(true);
        proxyFactory.setTarget(target);

        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                long startTime = System.nanoTime();
                Object result = invocation.proceed();
                long endTime = System.nanoTime();
                System.out.println(String.format("%s方法耗时(纳秒):%s", invocation.getMethod().getName(), endTime - startTime));
                return result;
            }
        });

        Service proxy = (Service) proxyFactory.getProxy();
        proxy.m1();
    }
}

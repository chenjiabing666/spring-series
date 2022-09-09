package com.javacode2018.aop.demo4;

import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AopTest4 {

    @Test
    public void test1() {
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(new FundsService());
        //添加一个方法前置通知，判断用户名不是“陈某”的时候，抛出非法访问异常
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
                String userName = (String) args[0];
                //如果不是陈某的时候，抛出非法访问异常
                if (!"陈某".equals(userName)) {
                    throw new RuntimeException(String.format("[%s]非法访问!", userName));
                }
            }
        });
        //通过代理工厂创建代理
        FundsService proxy = (FundsService) proxyFactory.getProxy();
        //调用代理的方法
        proxy.recharge("陈某", 100);
        proxy.recharge("张学友", 100);
    }

    public static class SendMsgThrowsAdvice implements ThrowsAdvice {
        //注意方法名称必须为afterThrowing
        public void afterThrowing(Method method, Object[] args, Object target, RuntimeException e) {
            //监控到异常后发送消息通知开发者
            System.out.println("异常警报：");
            System.out.println(String.format("method:[%s]，args:[%s]", method.toGenericString(), Arrays.stream(args).collect(Collectors.toList())));
            System.out.println(e.getMessage());
            System.out.println("请尽快修复bug！");
        }
    }

    @Test
    public void test2() {
        //目标对象
        FundsService target = new FundsService();
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(target);
        //添加一个异常通知，发现异常之后发送消息给开发者尽快修复bug
        proxyFactory.addAdvice(new SendMsgThrowsAdvice());
        //通过代理工厂创建代理
        FundsService proxy = (FundsService) proxyFactory.getProxy();
        //调用代理的方法
        proxy.cashOut("陈某", 2000);
    }
}
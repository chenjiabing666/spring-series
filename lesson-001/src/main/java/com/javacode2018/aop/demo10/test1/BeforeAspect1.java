package com.javacode2018.aop.demo10.test1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeAspect1 {

    @Pointcut("execution(* com.javacode2018.aop.demo10.test1.Service1.*(..))")
    public void pc() {
    }

    @Before("com.javacode2018.aop.demo10.test1.BeforeAspect1.pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知!");
    }
}

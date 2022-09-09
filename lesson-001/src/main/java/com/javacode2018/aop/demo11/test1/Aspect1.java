package com.javacode2018.aop.demo11.test1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //@1
@Aspect //@2
public class Aspect1 {

    @Pointcut("execution(* com.javacode2018.aop.demo11.test1..*(..))") //@3
    public void pc() {
    }

    @Before("com.javacode2018.aop.demo11.test1.Aspect1.pc()") //@4
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知,target:" + joinPoint.getTarget()); //@5
    }
}

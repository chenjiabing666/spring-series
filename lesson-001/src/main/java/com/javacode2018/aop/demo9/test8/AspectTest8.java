package com.javacode2018.aop.demo9.test8;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTest8 {
    @Pointcut("@args(..,com.javacode2018.aop.demo9.test8.Ann8)")
    public void pc() {
    }

    @Before("pc()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint);
    }
}

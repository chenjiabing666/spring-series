package com.javacode2018.aop.demo9.test4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTest4 {

    //@1：目标类型必须是Service3类型的
    @Pointcut("target(com.javacode2018.aop.demo9.test3.Service3+)")
    public void pc() {
    }

    @Before("pc()")
    public void beforeAdvice(JoinPoint joinpoint) {
        System.out.println(joinpoint);
    }

}
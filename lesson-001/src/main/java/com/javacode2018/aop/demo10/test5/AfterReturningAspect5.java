package com.javacode2018.aop.demo10.test5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class AfterReturningAspect5 {
    @Pointcut("execution(* com.javacode2018.aop.demo10.test1.Service1.*(..))")
    public void pc() {
    }

    @AfterReturning(value = "com.javacode2018.aop.demo10.test5.AfterReturningAspect5.pc()", returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, Object retVal) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(String.format("%s返回值：%s", methodSignature.getMethod(), retVal));
    }

}

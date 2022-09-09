package com.javacode2018.tx.demo10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Component
@Aspect
@Order(2)
public class TransactionInterceptorAfter {

    @Pointcut("execution(* com.javacode2018.tx.demo10.UserService.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object tsAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------after start!!!");
        Object result = joinPoint.proceed();
        System.out.println("--------after end!!!");
        return result;
    }
}

package com.javacode2018.readwritesplit.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true, order = Integer.MAX_VALUE - 1)
@ComponentScan(basePackageClasses = IService.class)
public class ReadWriteConfiguration {
}

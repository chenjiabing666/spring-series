package com.javacode2018.aop.demo9.test13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // 这个可以启用通过AspectJ方式自动为符合条件的bean创建代理
public class MainConfig13 {

    //将Aspect13注册到spring容器
    @Bean
    public Aspect13 aspect13() {
        return new Aspect13();
    }

    @Bean
    public BeanService beanService1() {
        return new BeanService("beanService1");
    }

    @Bean
    public BeanService beanService2() {
        return new BeanService("beanService2");
    }
}

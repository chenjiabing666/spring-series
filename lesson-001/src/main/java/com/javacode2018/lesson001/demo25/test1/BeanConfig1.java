package com.javacode2018.lesson001.demo25.test1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig1 {
    @Bean
    public IService service1() {
        return new Service1();
    }
}

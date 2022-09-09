package com.javacode2018.lesson001.demo25.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig2 {
    @Bean
    public IService service2() {
        return new Service2();
    }
}

package com.javacode2018.lesson003.demo3.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainConfig3 {
    @Bean
    public UserModel user1() {
        return new UserModel();
    }

    @Bean
    public UserModel user2() {
        return new UserModel();
    }

    @Bean
    public String name() {
        return "陈某Java,带大家成功java高手!";
    }
}

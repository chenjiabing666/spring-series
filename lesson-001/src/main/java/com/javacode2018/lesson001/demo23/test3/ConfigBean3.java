package com.javacode2018.lesson001.demo23.test3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean3 {
    @Bean
    public String name3() {
        String name = "陈某Java 3";
        System.out.println(name);
        return name;
    }
}

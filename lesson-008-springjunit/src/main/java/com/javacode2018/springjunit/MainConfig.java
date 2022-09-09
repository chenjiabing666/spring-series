package com.javacode2018.springjunit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    @Bean
    public String name() {
        return "陈某java";
    }

    @Bean
    public int age() {
        return 30;
    }
}

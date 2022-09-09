package com.javacode2018.lesson001.demo21;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

public class User {
    @Bean
    public Car car() {
        return new Car("user car!");
    }
}

package com.javacode2018.lesson001.demo21;

import org.springframework.context.annotation.*;

@Configuration
@Import({User.class})
public class Config {
    @Bean
    public Car car() {
        return new Car("config car!");
    }
}

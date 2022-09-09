package com.javacode2018.lesson002.test19.demo3;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig3 {
    @Bean
    public MessageSource messageSource(){
        return new MessageSourceFromDb();
    }
}

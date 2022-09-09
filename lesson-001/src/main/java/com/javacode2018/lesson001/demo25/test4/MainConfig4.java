package com.javacode2018.lesson001.demo25.test4;

import com.javacode2018.lesson001.demo25.test3.MyCondition1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig4 {
    @Conditional(MyCondition1.class) //@1
    @Bean
    public String name() {
        return "陈某Java";
    }

    @Bean
    public String address() {
        return "上海市";
    }
}

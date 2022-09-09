package com.javacode2018.lesson001.demo27.test3;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@DependsOn({"service2", "service3"})
@Component
public class Service1 {
    public Service1() {
        System.out.println("create Service1");
    }
}

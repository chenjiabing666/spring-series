package com.javacode2018.lesson002.demo17.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2 {

    @Autowired
    private com.javacode2018.lesson002.demo17.module1.Service1 service1;

    public String m1() {
        return this.service1.m1();
    }

}

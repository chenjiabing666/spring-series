package com.javacode2018.lesson002.demo2;

import org.springframework.beans.factory.annotation.Autowired;

public class Service2 {

    @Autowired
    private Service1 service1;

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}

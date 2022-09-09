package com.javacode2018.lesson002.demo12;

import org.springframework.stereotype.Component;

@Component
public class Service1 {

    public Service1() {
        System.out.println("create " + this.getClass());
    }

}

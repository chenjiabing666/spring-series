package com.javacode2018.cycledependency.demo1;

import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }
}

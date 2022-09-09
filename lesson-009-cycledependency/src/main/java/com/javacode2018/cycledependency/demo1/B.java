package com.javacode2018.cycledependency.demo1;

import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;

    public B(A a) {
        this.a = a;
    }
}

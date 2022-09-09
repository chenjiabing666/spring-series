package com.javacode2018.lesson002.demo13;

import javax.annotation.PreDestroy;

public class ServiceB {
    public ServiceB() {
        System.out.println("create " + this.getClass());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy()");
    }
}

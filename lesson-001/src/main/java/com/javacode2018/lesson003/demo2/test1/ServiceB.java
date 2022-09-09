package com.javacode2018.lesson003.demo2.test1;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}

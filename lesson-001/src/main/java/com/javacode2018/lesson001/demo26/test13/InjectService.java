package com.javacode2018.lesson001.demo26.test13;

import org.springframework.beans.factory.annotation.Autowired;

public class InjectService {

    @Autowired
    private IService service1;

    @Override
    public String toString() {
        return "InjectService{" +
                "service1=" + service1 +
                '}';
    }
}

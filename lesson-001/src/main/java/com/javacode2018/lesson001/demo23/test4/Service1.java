package com.javacode2018.lesson001.demo23.test4;

import org.springframework.stereotype.Component;

@Component
public class Service1 {
    public void m1() {
        System.out.println(this.getClass() + ".m1()");
    }
}

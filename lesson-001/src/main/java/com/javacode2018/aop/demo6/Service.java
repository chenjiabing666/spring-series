package com.javacode2018.aop.demo6;

public class Service implements IService {
    @Override
    public void say(String name) {
        System.out.println("hello：" + name);
    }
}

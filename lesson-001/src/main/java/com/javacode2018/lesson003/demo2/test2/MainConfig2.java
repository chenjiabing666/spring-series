package com.javacode2018.lesson003.demo2.test2;

public class MainConfig2 {

    public static void main(String[] args) {
        //创建serviceA
        ServiceA serviceA = new ServiceA();
        //创建serviceB
        ServiceB serviceB = new ServiceB();
        //将serviceA注入到serviceB中
        serviceB.setServiceA(serviceA);
        //将serviceB注入到serviceA中
        serviceA.setServiceB(serviceB);
    }
}

package com.javacode2018.aop.demo9.test10;

@Ann10
class S10Parent {

    public void m1() {
        System.out.println("我是S10Parent.m1()方法");
    }

    public void m2() {
        System.out.println("我是S10Parent.m2()方法");
    }
}

public class S10 extends S10Parent {

    @Override
    public void m2() {
        System.out.println("我是S10.m2()方法");
    }

    public void m3() {
        System.out.println("我是S10.m3()方法");
    }
}

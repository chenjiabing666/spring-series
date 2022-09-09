package com.javacode2018.aop.demo9.test7;

import java.lang.annotation.Target;

@Ann7
class S7Parent {
}

public class S7 extends S7Parent {
    public void m1() {
        System.out.println("我是m1");
    }

    public static void main(String[] args) {
        System.out.println(S7.class.getAnnotation(Target.class));
    }
}

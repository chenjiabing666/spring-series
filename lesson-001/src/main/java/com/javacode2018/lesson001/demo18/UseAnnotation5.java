package com.javacode2018.lesson001.demo18;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Ann5 {
    String[] name() default {"陈某java", "spring系列"};//@1
    int[] score() default 1; //@2
    int age() default 30; //@3
    String address(); //@4
}

@Ann5(age = 32,address = "上海") //@5
public class UseAnnotation5 {

}

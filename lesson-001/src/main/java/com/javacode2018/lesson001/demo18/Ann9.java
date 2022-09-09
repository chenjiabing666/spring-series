package com.javacode2018.lesson001.demo18;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ann9 {
    String value();
}
package com.javacode2018.lesson001.demo18;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Ann1 { //@1)
}

@Ann1 //@2
public class UseAnnotation1 {

}

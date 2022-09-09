package com.javacode2018.lesson001.demo22.test3;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component //@1
public @interface MyBean {
    @AliasFor(annotation = Component.class) //@2
    String value() default ""; //@3
}
package com.javacode2018.lesson001.demo25.test2;


import org.springframework.context.annotation.Conditional;

@Conditional(EnvCondition.class)
public class Service {
}

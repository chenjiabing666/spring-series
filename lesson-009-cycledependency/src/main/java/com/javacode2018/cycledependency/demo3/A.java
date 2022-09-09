package com.javacode2018.cycledependency.demo3;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("loginA") //类A依赖于loginA，但是又不想通过属性注入的方式强依赖
public class A {

}

package com.javacode2018.spel.test1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LessonModel {
    @Value("你好,%{@name},%{@msg}")
    private String desc;

    @Override
    public String toString() {
        return "LessonModel{" +
                "desc='" + desc + '\'' +
                '}';
    }
}

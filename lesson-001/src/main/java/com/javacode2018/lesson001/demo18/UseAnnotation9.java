package com.javacode2018.lesson001.demo18;

import java.lang.annotation.*;

public class UseAnnotation9 {
    public static void main(String[] args) {
        for (Annotation annotation : UseAnnotation9.class.getPackage().getAnnotations()) {
            System.out.println(annotation);
        }
    }
}

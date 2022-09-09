package com.javacode2018.lesson003.demo3.test3;

import org.springframework.beans.factory.annotation.Autowired;

public class UserModel {
    @Autowired
    private String name; //@1

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                '}';
    }
}

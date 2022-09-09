package com.javacode2018.lesson002.demo18.test3;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@MyScope
public class User {

    private String username;

    public User() {
        System.out.println("---------创建User对象" + this);
        this.username = UUID.randomUUID().toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

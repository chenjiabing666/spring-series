package com.javacode2018.cycledependency.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginA implements ILogin {
    @Autowired
    private X x;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }
}

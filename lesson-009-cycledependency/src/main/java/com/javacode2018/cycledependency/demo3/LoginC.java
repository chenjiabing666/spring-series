package com.javacode2018.cycledependency.demo3;

//代理
public class LoginC implements ILogin {

    private ILogin target;

    public LoginC(ILogin target) {
        this.target = target;
    }
}

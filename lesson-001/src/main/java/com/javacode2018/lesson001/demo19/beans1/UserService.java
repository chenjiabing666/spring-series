package com.javacode2018.lesson001.demo19.beans1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Autowired
    private IUserDao userDao2;

    @Override
    public String toString() {
        return "UserService{" +
                "userDao1=" + userDao2 +
                '}';
    }
}

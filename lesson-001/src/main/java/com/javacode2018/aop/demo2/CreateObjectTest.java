package com.javacode2018.aop.demo2;

import org.junit.Test;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;

public class CreateObjectTest {
    public static class User {
        private String name;

        public User() {
            System.out.println("默认构造函数");
        }

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void test1() {
        Objenesis objenesis = new ObjenesisStd();
        User user = objenesis.newInstance(User.class);
        System.out.println(user);
    }

    @Test
    public void test2() {
        Objenesis objenesis = new ObjenesisStd();
        ObjectInstantiator<User> userObjectInstantiator = objenesis.getInstantiatorOf(User.class);
        User user1 = userObjectInstantiator.newInstance();
        System.out.println(user1);
        User user2 = userObjectInstantiator.newInstance();
        System.out.println(user2);
        System.out.println(user1 == user2);
    }
}

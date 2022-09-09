package com.javacode2018.lesson001.demo3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
@Getter
@Setter
@ToString
public class UserModel {

    private String name;
    private int age;

    public UserModel() {
        this.name = "我是通过UserModel的无参构造方法创建的!";
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

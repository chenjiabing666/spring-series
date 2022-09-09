package com.javacode2018.lesson001.demo3;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class UserFactory {
    public UserModel buildUser1() {
        System.out.println("----------------------1");
        UserModel userModel = new UserModel();
        userModel.setName("bean实例方法创建的对象!");
        return userModel;
    }

    public UserModel buildUser2(String name, int age) {
        System.out.println("----------------------2");
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }
}

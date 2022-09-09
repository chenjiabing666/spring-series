package com.javacode2018.lesson001.demo3;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class UserStaticFactory {

    /**
     * 静态无参方法创建UserModel
     *
     * @return
     */
    public static UserModel buildUser1() {

        System.out.println(UserStaticFactory.class + ".buildUser1()");

        UserModel userModel = new UserModel();
        userModel.setName("我是无参静态构造方法创建的!");
        return userModel;
    }

    /**
     * 静态有参方法创建UserModel
     *
     * @param name 名称
     * @param age  年龄
     * @return
     */
    public static UserModel buildUser2(String name, int age) {

        System.out.println(UserStaticFactory.class + ".buildUser2()");

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }
}

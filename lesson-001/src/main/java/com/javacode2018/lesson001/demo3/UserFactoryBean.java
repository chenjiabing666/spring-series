package com.javacode2018.lesson001.demo3;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class UserFactoryBean implements FactoryBean<UserModel> {
    int count = 1;

    @Nullable
    @Override
    public UserModel getObject() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setName("我是通过FactoryBean创建的第" + count++ + "对象");
        return userModel;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return UserModel.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

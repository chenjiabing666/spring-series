package com.javacode2018.mybatis.module1.service;

import com.javacode2018.mybatis.module1.model.User1Model;

import java.util.List;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
public interface IUser1Service {
    /**
     * 插入用户信息
     *
     * @param userModel
     * @return
     */
    User1Model insert(User1Model userModel);

    /**
     * 查询用户所有记录
     *
     * @return
     */
    List<User1Model> getList();
}
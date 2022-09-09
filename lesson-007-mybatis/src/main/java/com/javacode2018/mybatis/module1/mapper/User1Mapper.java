package com.javacode2018.mybatis.module1.mapper;

import com.javacode2018.mybatis.module1.model.User1Model;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Mapper
public interface User1Mapper {
    void insert(User1Model userModel);

    List<User1Model> getList();
}

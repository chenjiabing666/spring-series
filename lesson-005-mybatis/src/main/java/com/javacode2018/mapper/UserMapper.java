package com.javacode2018.mapper;

import com.javacode2018.mybatis.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Mapper
public interface UserMapper {
    void insert(UserModel userModel);
    List<UserModel> getList();
}

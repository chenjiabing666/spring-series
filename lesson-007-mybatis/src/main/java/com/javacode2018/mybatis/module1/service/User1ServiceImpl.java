package com.javacode2018.mybatis.module1.service;

import com.javacode2018.mybatis.module1.Module1SpringConfig;
import com.javacode2018.mybatis.module1.mapper.User1Mapper;
import com.javacode2018.mybatis.module1.model.User1Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Service
public class User1ServiceImpl implements IUser1Service {
    @Autowired
    private User1Mapper userMapper;

    @Transactional(transactionManager = Module1SpringConfig.TRANSACTION_MANAGER_BEAN_NAME, rollbackFor = Exception.class)
    @Override
    public User1Model insert(User1Model userModel) {
        userMapper.insert(userModel);
        return userModel;
    }

    @Transactional(transactionManager = Module1SpringConfig.TRANSACTION_MANAGER_BEAN_NAME, propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<User1Model> getList() {
        return userMapper.getList();
    }
}

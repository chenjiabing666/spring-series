package com.javacode2018.mybatis.module2.service;

import com.javacode2018.mybatis.module1.Module1SpringConfig;
import com.javacode2018.mybatis.module2.Module2SpringConfig;
import com.javacode2018.mybatis.module2.mapper.User2Mapper;
import com.javacode2018.mybatis.module2.model.User2Model;
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
public class User2ServiceImpl implements IUser2Service {
    @Autowired
    private User2Mapper userMapper;

    @Transactional(transactionManager = Module2SpringConfig.TRANSACTION_MANAGER_BEAN_NAME, rollbackFor = Exception.class)
    @Override
    public User2Model insert(User2Model userModel) {
        userMapper.insert(userModel);
        return userModel;
    }

    @Transactional(transactionManager = Module2SpringConfig.TRANSACTION_MANAGER_BEAN_NAME, propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<User2Model> getList() {
        return userMapper.getList();
    }
}

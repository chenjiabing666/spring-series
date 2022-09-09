package com.javacode2018.tx.demo10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Component
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addUser() {
        System.out.println("--------UserService.addUser start");
        this.jdbcTemplate.update("insert into t_user(name) VALUES (?)", "张三");
        System.out.println("--------UserService.addUser end");
    }
}

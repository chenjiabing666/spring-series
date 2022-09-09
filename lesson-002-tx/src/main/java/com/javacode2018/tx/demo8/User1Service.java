package com.javacode2018.tx.demo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class User1Service {
    @Autowired
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    private User2Service user2Service;

    @Transactional(transactionManager = "transactionManager1", propagation = Propagation.REQUIRED)
    public void required() {
        this.jdbcTemplate1.update("insert into user1(name) VALUES (?)", "张三");
        this.user2Service.required();
        this.jdbcTemplate1.update("insert into user1(name) VALUES (?)", "王五");
        throw new RuntimeException();
    }

}

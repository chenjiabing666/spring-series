package com.javacode2018.tx.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Service1 {
    @Autowired
    private Service2 service2;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void m1() {
        this.jdbcTemplate.update("INSERT into t1 values ('m1')");
        this.service2.m2();
    }
}

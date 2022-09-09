package com.javacode2018.tx.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Service2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void m2() {
        this.jdbcTemplate.update("INSERT into t1 values ('m2')");
    }
}

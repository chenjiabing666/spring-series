package com.javacode2018.tx.demo11;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
public class Demo11Test {

    private AnnotationConfigApplicationContext context;
    private UserService userService;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        this.context = new AnnotationConfigApplicationContext(MainConfig11.class);
        userService = context.getBean(UserService.class);
        this.jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcTemplate.update("truncate table t_user");
        jdbcTemplate.update("truncate table t_msg");
        jdbcTemplate.update("truncate table t_msg_order");
    }

    @Test
    public void test1() {
        this.userService.register(1L, "陈某");
    }

    @Test
    public void test2() {
        this.userService.registerFail(1L, "张三");
    }

    @Test
    public void test3() {
        UserService1 userService1 = this.context.getBean(UserService1.class);
        userService1.nested();
    }
}

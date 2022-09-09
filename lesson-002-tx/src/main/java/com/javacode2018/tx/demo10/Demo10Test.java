package com.javacode2018.tx.demo10;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
public class Demo10Test {

    private UserService userService;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig10.class);
        userService = context.getBean(UserService.class);
        this.jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcTemplate.update("truncate table t_user");
    }

    @Test
    public void test1() {
        this.userService.addUser();
    }
}

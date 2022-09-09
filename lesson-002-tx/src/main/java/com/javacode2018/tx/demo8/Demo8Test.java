package com.javacode2018.tx.demo8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo8Test {

    private User1Service user1Service;
    private JdbcTemplate jdbcTemplate1;

    //@Before标注的方法会在任意@Test方法执行之前执行，我们这在里清理一下2库中4张表的数据
    @Before
    public void before() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig8.class);
        this.user1Service = context.getBean(User1Service.class);
        this.jdbcTemplate1 = context.getBean("jdbcTemplate1", JdbcTemplate.class);
        jdbcTemplate1.update("truncate table ds1.user1");
        jdbcTemplate1.update("truncate table ds1.user2");
    }

    //@After标注的方法会在任意@Test方法执行完毕之后执行，我们在此处输出4张表的数据，用来查看测试案例之后，表中的数据清空
    @After
    public void after() {
        System.out.println("ds1.user1表数据：" + this.jdbcTemplate1.queryForList("SELECT * from user1"));
        System.out.println("ds1.user2表数据：" + this.jdbcTemplate1.queryForList("SELECT * from user2"));
    }

    @Test
    public void test1() {
        this.user1Service.required();
    }

}

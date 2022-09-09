package com.javacode2018.tx.demo7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo7Test {

    private Tx1Service txService1;
    private JdbcTemplate jdbcTemplate1;
    private JdbcTemplate jdbcTemplate2;

    //@Before标注的方法会在任意@Test方法执行之前执行，我们这在里清理一下2库中4张表的数据
    @Before
    public void before() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
        txService1 = context.getBean(Tx1Service.class);
        this.jdbcTemplate1 = context.getBean("jdbcTemplate1", JdbcTemplate.class);
        this.jdbcTemplate2 = context.getBean("jdbcTemplate2", JdbcTemplate.class);
        jdbcTemplate1.update("truncate table ds1.user1");
        jdbcTemplate1.update("truncate table ds1.user2");
        jdbcTemplate2.update("truncate table ds2.user1");
        jdbcTemplate2.update("truncate table ds2.user2");
    }

    //@After标注的方法会在任意@Test方法执行完毕之后执行，我们在此处输出4张表的数据，用来查看测试案例之后，表中的数据清空
    @After
    public void after() {
        System.out.println("ds1.user1表数据：" + this.jdbcTemplate1.queryForList("SELECT * from user1"));
        System.out.println("ds1.user2表数据：" + this.jdbcTemplate1.queryForList("SELECT * from user2"));
        System.out.println("ds2.user1表数据：" + this.jdbcTemplate2.queryForList("SELECT * from user1"));
        System.out.println("ds2.user2表数据：" + this.jdbcTemplate2.queryForList("SELECT * from user2"));
    }

    @Test
    public void test1() {
        this.txService1.test1();
    }

    @Test
    public void test2() {
        this.txService1.test2();
    }

    @Test
    public void test3() {
        this.txService1.test3();
    }

    @Test
    public void test4() {
        this.txService1.test4();
    }

    @Test
    public void test5() {
        this.txService1.test5();
    }


}

package com.javacode2018.readwritesplit.demo1;

import com.javacode2018.readwritesplit.base.DsType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo1Test {

    UserService userService;

    @Before
    public void before() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();
        this.userService = context.getBean(UserService.class);
    }

    @Test
    public void test1() {
        System.out.println(this.userService.getUserNameById(1, DsType.MASTER));
        System.out.println(this.userService.getUserNameById(1, DsType.SLAVE));
    }

    @Test
    public void test2() {
        long id = System.currentTimeMillis();
        System.out.println(id);
        this.userService.insert(id, "张三");
    }

    @Test
    public void test3() throws SQLException {
        this.userService.test1(1, DsType.SLAVE);
    }
}

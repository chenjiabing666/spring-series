package com.javacode2018.tx.demo3;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8,所有文章以系列的方式呈现，带领大家成为java高手，
 * 目前已出：java高并发系列、mysq|高手系列、Maven高手系列、mybatis系列、spring系列，
 * 正在连载springcloud系列，欢迎关注！
 */
public class Demo3Test {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        UserService userService = context.getBean(UserService.class);
        userService.bus1();
        System.out.println(userService.userList());
    }
}

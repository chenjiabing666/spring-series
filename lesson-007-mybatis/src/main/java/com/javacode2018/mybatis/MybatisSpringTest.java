package com.javacode2018.mybatis;

import com.javacode2018.mybatis.module1.model.User1Model;
import com.javacode2018.mybatis.module1.service.IUser1Service;
import com.javacode2018.mybatis.module2.model.User2Model;
import com.javacode2018.mybatis.module2.service.IUser2Service;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
public class MybatisSpringTest {
    @Test
    public void testModel1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        IUser1Service user1Service = context.getBean(IUser1Service.class);
        User1Model userModel = User1Model.builder().name("张三").build();
        user1Service.insert(userModel);
        System.out.println(userModel);
        System.out.println(user1Service.getList());
    }

    @Test
    public void testModel2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        IUser2Service user2Service = context.getBean(IUser2Service.class);
        User2Model userModel = User2Model.builder().name("李四").build();
        user2Service.insert(userModel);
        System.out.println(userModel);
        System.out.println(user2Service.getList());
    }
}
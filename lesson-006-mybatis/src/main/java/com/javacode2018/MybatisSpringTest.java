package com.javacode2018;

import com.javacode2018.mybatis.model.UserModel;
import com.javacode2018.service.IUserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
public class MybatisSpringTest {
    @Test
    public void insert() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        IUserService userService = context.getBean(IUserService.class);
        UserModel userModel = UserModel.builder().name("张三").build();
        userService.insert(userModel);
        System.out.println(userModel);
    }

    @Test
    public void getList() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        IUserService userService = context.getBean(IUserService.class);
        List<UserModel> userModelList = userService.getList();
        System.out.println(userModelList);
    }
}

package com.javacode2018.lesson001.demo27;

import com.javacode2018.lesson001.demo27.test1.MainConfig1;
import com.javacode2018.lesson001.demo27.test1.ServiceA;
import com.javacode2018.lesson001.demo27.test2.MainConfig2;
import com.javacode2018.lesson001.demo27.test3.MainConfig3;
import com.javacode2018.lesson001.demo27.test3.Service1;
import com.javacode2018.lesson001.demo27.test4.MainConfig4;
import com.javacode2018.lesson001.demo27.test5.MainConfig5;
import com.javacode2018.lesson001.demo27.test6.MainConfig6;
import com.javacode2018.lesson001.demo27.test7.MainConfig7;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Demo27Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        for (int i = 0; i < 2; i++) {
            System.out.println(context.getBean(ServiceA.class));
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (int i = 0; i < 2; i++) {
            System.out.println(context.getBean(com.javacode2018.lesson001.demo27.test2.ServiceA.class));
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        System.out.println(context.getBean(Service1.class));
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        System.out.println(context.getBean(com.javacode2018.lesson001.demo27.test4.Service1.class));
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test6() {
        System.out.println("准备启动spring容器");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
        System.out.println("spring容器启动完毕");
        System.out.println(context.getBean(com.javacode2018.lesson001.demo27.test6.Service1.class));
    }

    @Test
    public void test7() {
        System.out.println("准备启动spring容器");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
        System.out.println("spring容器启动完毕");

        for (String beanName : Arrays.asList("name", "age", "address")) {
            System.out.println("----------");
            System.out.println("getBean:" + beanName + ",start");
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
            System.out.println("getBean:" + beanName + ",end");
        }
    }
}

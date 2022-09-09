package com.javacode2018.lesson001.demo23;

import com.javacode2018.lesson001.demo23.test1.MainConfig1;
import com.javacode2018.lesson001.demo23.test2.MainConfig2;
import com.javacode2018.lesson001.demo23.test3.ConfigMain;
import com.javacode2018.lesson001.demo23.test4.MainConfig;
import com.javacode2018.lesson001.demo23.test4.Service1;
import com.javacode2018.lesson001.demo23.test4.Service2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class ImportTest {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigMain.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Service1 service1 = context.getBean(Service1.class);
        Service2 service2 = context.getBean(Service2.class);
        service1.m1();
        service2.m1();
    }
}

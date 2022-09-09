package com.javacode2018.lesson001.demo22;

import com.javacode2018.lesson001.demo22.test1.ScanBean1;
import com.javacode2018.lesson001.demo22.test2.ScanBean2;
import com.javacode2018.lesson001.demo22.test3.ScanBean3;
import com.javacode2018.lesson001.demo22.test4.ScanBean4;
import com.javacode2018.lesson001.demo22.test5.ScanBean5;
import com.javacode2018.lesson001.demo22.test6.ScanBean6;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class ComponentScanTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean1.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean3.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean4.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean5.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean6.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }
}

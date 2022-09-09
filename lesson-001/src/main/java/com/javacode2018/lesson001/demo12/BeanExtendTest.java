package com.javacode2018.lesson001.demo12;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * bean定义继承案例
 */
public class BeanExtendTest {
    @Test
    public void normalBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo12/normalBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("serviceB:" + context.getBean(ServiceB.class));
        System.out.println("serviceC:" + context.getBean(ServiceC.class));
    }

    @Test
    public void extendBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo12/extendBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("serviceB:" + context.getBean(ServiceB.class));
        System.out.println("serviceC:" + context.getBean(ServiceC.class));

        System.out.println(context.getBean("baseService"));
    }
}

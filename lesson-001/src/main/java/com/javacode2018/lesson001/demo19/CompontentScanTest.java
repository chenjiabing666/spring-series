package com.javacode2018.lesson001.demo19;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class CompontentScanTest {
    @Test
    public void test1() {
        String configLocation = "com/javacode2018/lesson001/demo19/beans1.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s + "->" + context.getBean(s));
        }
    }
}

package com.javacode2018.lesson001.demo5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class IocUtils {
    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }
}

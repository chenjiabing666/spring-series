package com.javacode2018.lesson001.demo10;

import com.javacode2018.lesson001.demo5.IocUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo10/beans.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}

package com.javacode2018.lesson001.demo21;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s + "->" + context.getBean(s));
        }

        Car car = context.getBean(Car.class);
        car.print();
    }
}

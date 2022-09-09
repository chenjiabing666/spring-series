package com.javacode2018.lesson001.other.test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.javacode2018.lesson001.other")
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Client.class);
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        System.out.println(context.getBean(Config.jobs.class));
    }
}

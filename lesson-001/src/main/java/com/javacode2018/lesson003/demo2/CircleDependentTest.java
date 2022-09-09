package com.javacode2018.lesson003.demo2;

import com.javacode2018.lesson003.demo2.test1.MainConfig1;
import com.javacode2018.lesson003.demo2.test2.ServiceA;
import com.javacode2018.lesson003.demo2.test2.ServiceB;
import com.javacode2018.lesson003.demo2.test3.MainConfig3;
import com.javacode2018.lesson003.demo2.test3.Service1;
import com.javacode2018.lesson003.demo2.test3.Service2;
import com.javacode2018.lesson003.demo2.test4.MainConfig4;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircleDependentTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
    }

    @Test
    public void test2() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("serviceA",
                BeanDefinitionBuilder.
                        genericBeanDefinition(ServiceA.class).
                        setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE).
                        getBeanDefinition());
        factory.registerBeanDefinition("serviceB",
                BeanDefinitionBuilder.
                        genericBeanDefinition(ServiceB.class).
                        setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE).
                        setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE).
                        getBeanDefinition());

        System.out.println(factory.getBean("serviceB"));
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig3.class);
        context.refresh();
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //创建一个BeanFactoryPostProcessor：BeanFactory后置处理器
        context.addBeanFactoryPostProcessor(beanFactory -> {
            if (beanFactory instanceof DefaultListableBeanFactory) {
                //将allowRawInjectionDespiteWrapping设置为true
                ((DefaultListableBeanFactory) beanFactory).setAllowRawInjectionDespiteWrapping(true);
            }
        });
        context.register(MainConfig3.class);
        context.refresh();

        System.out.println("容器初始化完毕");

        //获取service1
        Service1 service1 = context.getBean(Service1.class);
        //获取service2
        Service2 service2 = context.getBean(Service2.class);

        System.out.println("----A-----");
        service2.m1(); //@1
        System.out.println("----B-----");
        service1.m1(); //@2
        System.out.println("----C-----");
        System.out.println(service2.getService1() == service1);
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        System.out.println("容器初始化完毕");

        //获取service1
        com.javacode2018.lesson003.demo2.test4.Service1 service1 = context.getBean(com.javacode2018.lesson003.demo2.test4.Service1.class);
        //获取service2
        com.javacode2018.lesson003.demo2.test4.Service2 service2 = context.getBean(com.javacode2018.lesson003.demo2.test4.Service2.class);

        System.out.println("----A-----");
        service2.m1(); //@1
        System.out.println("----B-----");
        service1.m1(); //@2
        System.out.println("----C-----");
        System.out.println(service2.getService1() == service1);
    }
}

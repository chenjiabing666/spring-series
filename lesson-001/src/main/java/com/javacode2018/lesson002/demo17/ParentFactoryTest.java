package com.javacode2018.lesson002.demo17;

import com.javacode2018.lesson002.demo17.module1.Module1Config;
import com.javacode2018.lesson002.demo17.module2.Module2Config;
import com.javacode2018.lesson002.demo17.module2.Service3;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class ParentFactoryTest {

    @Test
    public void test1() {
        //定义容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册bean
        context.register(Module1Config.class, Module2Config.class);
        //启动容器
        context.refresh();
    }

    @Test
    public void test2() {
        //创建父容器
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        //向父容器中注册Module1Config配置类
        parentContext.register(Module1Config.class);
        //启动父容器
        parentContext.refresh();

        //创建子容器
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        //向子容器中注册Module2Config配置类
        childContext.register(Module2Config.class);
        //给子容器设置父容器
        childContext.setParent(parentContext);
        //启动子容器
        childContext.refresh();

        //从子容器中获取Service3
        Service3 service3 = childContext.getBean(Service3.class);
        System.out.println(service3.m1());
        System.out.println(service3.m2());
    }

    @Test
    public void test3() {
        //创建父容器parentFactory
        DefaultListableBeanFactory parentFactory = new DefaultListableBeanFactory();
        //向父容器parentFactory注册一个bean[userName->"陈某Java"]
        parentFactory.registerBeanDefinition("userName",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("陈某Java").
                        getBeanDefinition());

        //创建一个子容器childFactory
        DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory();
        //调用setParentBeanFactory指定父容器
        childFactory.setParentBeanFactory(parentFactory);
        //向子容器parentFactory注册一个bean[address->"上海"]
        childFactory.registerBeanDefinition("address",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("上海").
                        getBeanDefinition());

        System.out.println("获取bean【userName】：" + childFactory.getBean("userName"));

        System.out.println(Arrays.asList(childFactory.getBeanNamesForType(String.class)));

        //层次查找所有符合类型的bean名称
        String[] beanNamesForTypeIncludingAncestors = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beanNamesForTypeIncludingAncestors));

        Map<String, String> beansOfTypeIncludingAncestors = BeanFactoryUtils.beansOfTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beansOfTypeIncludingAncestors));
    }
}

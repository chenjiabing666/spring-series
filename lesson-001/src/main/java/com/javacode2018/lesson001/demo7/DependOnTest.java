package com.javacode2018.lesson001.demo7;

import com.javacode2018.lesson001.demo5.IocUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * dependon详解
 */
public class DependOnTest {

    /**
     * 无依赖的bean创建和销毁的顺序
     */
    @Test
    public void normalBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:/com/javacode2018/lesson001/demo7/normalBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        //关闭容器
        context.close();
        System.out.println("spring容器已关闭!");
    }

    /**
     * 通过构造器强依赖的bean的创建和销毁顺序测试
     */
    @Test
    public void strongDependenceBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:/com/javacode2018/lesson001/demo7/strongDependenceBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }

    /**
     * 通过构造器强依赖的bean的创建和销毁顺序测试
     */
    @Test
    public void StrongDependenceBean1() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:/com/javacode2018/lesson001/demo7/strongDependenceBean1.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }

    /**
     * 通过depend-on来干预bean创建和销毁顺序
     */
    @Test
    public void dependOnBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:/com/javacode2018/lesson001/demo7/dependOnBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }

}

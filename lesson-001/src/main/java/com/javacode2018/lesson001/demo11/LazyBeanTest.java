package com.javacode2018.lesson001.demo11;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * bean默认是实时初始化的，可以通过bean元素的lazy-init="true"将bean定义为延迟初始化
 */
public class LazyBeanTest {

    @Test
    public void actualTimeBean() {
        System.out.println("spring容器启动中...");
        String beanXml = "classpath:/com/javacode2018/lesson001/demo11/actualTimeBean.xml";
        new ClassPathXmlApplicationContext(beanXml); //启动spring容器
        System.out.println("spring容器启动完毕...");
    }

    @Test
    public void lazyInitBean() {
        System.out.println("spring容器启动中...");
        String beanXml = "classpath:/com/javacode2018/lesson001/demo11/lazyInitBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml); //启动spring容器
        System.out.println("spring容器启动完毕...");
        System.out.println("从容器中开始查找LazyInitBean");
        LazyInitBean lazyInitBean = context.getBean(LazyInitBean.class);
        System.out.println("LazyInitBean:" + lazyInitBean);
    }

@Test
public void actualTimeDependencyLazyBean() {
    System.out.println("spring容器启动中...");
    String beanXml = "classpath:/com/javacode2018/lesson001/demo11/actualTimeDependencyLazyBean.xml";
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml); //启动spring容器
    System.out.println("spring容器启动完毕...");
}
}

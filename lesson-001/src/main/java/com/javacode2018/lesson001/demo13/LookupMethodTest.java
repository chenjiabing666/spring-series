package com.javacode2018.lesson001.demo13;


import com.javacode2018.lesson001.demo13.normal.ServiceA;
import com.javacode2018.lesson001.demo13.normal.ServiceB;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * lookupMethod：方法查找
 */
public class LookupMethodTest {

    @Test
    public void normalBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo13/normalBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class); //@3
        System.out.println(serviceB.getServiceA()); //@4
        System.out.println(serviceB.getServiceA()); //@5
    }

    @Test
    public void alicationcontextaware() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo13/alicationcontextaware.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(com.javacode2018.lesson001.demo13.applicationcontextaware.ServiceA.class)); //@1
        System.out.println(context.getBean(com.javacode2018.lesson001.demo13.applicationcontextaware.ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        com.javacode2018.lesson001.demo13.applicationcontextaware.ServiceB serviceB = context.getBean(com.javacode2018.lesson001.demo13.applicationcontextaware.ServiceB.class); //@3
        serviceB.say();
        serviceB.say();
    }

    @Test
    public void lookupmethod() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo13/lookupmethod.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(com.javacode2018.lesson001.demo13.lookupmethod.ServiceA.class)); //@1
        System.out.println(context.getBean(com.javacode2018.lesson001.demo13.lookupmethod.ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        com.javacode2018.lesson001.demo13.lookupmethod.ServiceB serviceB = context.getBean(com.javacode2018.lesson001.demo13.lookupmethod.ServiceB.class); //@3
        serviceB.say();
        serviceB.say();
    }
}

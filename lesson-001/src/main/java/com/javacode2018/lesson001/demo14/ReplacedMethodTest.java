package com.javacode2018.lesson001.demo14;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * replaced-method：方法替换
 */
public class ReplacedMethodTest {

    @Test
    public void replacedmethod() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo14/replacedmethod.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class); //@3
        serviceB.say();
        serviceB.say();
    }

}

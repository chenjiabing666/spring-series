package com.javacode2018.lesson001.demo6;

import com.javacode2018.lesson001.demo5.IocUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * xml中自动注入配置案例
 */
public class DiAutowireTest {

    @Test
    public void isAssignableFrom() {
        System.out.println(Object.class.isAssignableFrom(Integer.class)); //true
        System.out.println(Object.class.isAssignableFrom(int.class)); //false
        System.out.println(Object.class.isAssignableFrom(List.class)); //true
        System.out.println(Collection.class.isAssignableFrom(List.class)); //true
        System.out.println(List.class.isAssignableFrom(Collection.class)); //false
    }

    /**
     * 按照名称进行注入
     */
    @Test
    public void diAutowireByName() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo6/diAutowireByName.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diAutowireByName1"));
        System.out.println(context.getBean("diAutowireByName2"));
    }

    /**
     * 按照set方法参数类型进行注入
     */
    @Test
    public void diAutowireByType() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo6/diAutowireByType.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diAutowireByType1"));
    }

    /**
     * 按照类型注入集合
     */
    @Test
    public void diAutowireByTypeExtend() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo6/diAutowireByTypeExtend.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        //从容器中获取DiAutowireByTypeExtend
        DiAutowireByTypeExtend diAutowireByTypeExtend = context.getBean(DiAutowireByTypeExtend.class);
        //输出diAutowireByTypeExtend中的属性看一下
        System.out.println("serviceList：" + diAutowireByTypeExtend.getServiceList());
        System.out.println("baseServieList：" + diAutowireByTypeExtend.getBaseServieList());
        System.out.println("service1Map：" + diAutowireByTypeExtend.getService1Map());
        System.out.println("baseServieMap：" + diAutowireByTypeExtend.getBaseServieMap());
    }

    /**
     * 构造函数的方式进行自动注入
     */
    @Test
    public void diAutowireByConstructor() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo6/diAutowireByConstructor.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diAutowireByConstructor"));
    }

    /**
     * autowire=default
     */
    @Test
    public void diAutowireByDefault() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo6/diAutowireByDefault.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diAutowireByDefault1"));
        System.out.println(context.getBean("diAutowireByDefault2"));
        System.out.println(context.getBean(DiAutowireByName.class));
    }

}

package com.javacode2018.lesson001.demo8;

import com.javacode2018.lesson001.demo5.IocUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * bean元素的primary属性可以解决什么问题？
 */
public class PrimaryTest {
    @Test
    public void normalBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo8/normalBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        //下面我们通过spring容器的T getBean(Class<T> requiredType)方法获取容器中对应的bean
        NormalBean.IService service = context.getBean(NormalBean.IService.class);
        System.out.println(service);
    }

    @Test
    public void setterBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo8/setterBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
    }

    @Test
    public void primaryBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo8/primaryBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        PrimaryBean.IService service = context.getBean(PrimaryBean.IService.class); //@1
        System.out.println(service);
        PrimaryBean primaryBean = context.getBean(PrimaryBean.class); //@2
        System.out.println(primaryBean);
        System.out.println(context.getBeansOfType(PrimaryBean.IService.class));
    }

    @Test
    public void eagerlyBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo8/eagerlyBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        Arrays.stream(context.getBeanNamesForType(String.class, false, true)).forEach(System.out::println);
        System.out.println("----------------");
        Map<String, String> beansOfType = context.getBeansOfType(String.class, true, true);
        beansOfType.forEach((beanName, bean) -> {
            System.out.println(beanName + "->" + bean);
        });
    }
}

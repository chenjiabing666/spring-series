package com.javacode2018.lesson001.demo9;

import com.javacode2018.lesson001.demo5.IocUtils;
import com.javacode2018.lesson001.demo8.NormalBean;
import com.javacode2018.lesson001.demo8.PrimaryBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 * bean元素的autowire-candidate可以设置当前bean是否作为其他bean自动注入的候选bean
 */
public class AutowireCandidateTest {

    @Test
    public void setterBean() {
        String beanXml = "classpath:/com/javacode2018/lesson001/demo9/autowireCandidateBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean(SetterBean.class)); //@1

        SetterBean.IService service = context.getBean(SetterBean.IService.class); //@2
        System.out.println(service);
    }

}

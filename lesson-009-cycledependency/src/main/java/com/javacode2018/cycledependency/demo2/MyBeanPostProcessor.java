package com.javacode2018.cycledependency.demo2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("loginA")) {
            //loginA实现了ILogin
            return new LoginC((ILogin) bean);
        } else {
            return bean;
        }
    }
}

package com.javacode2018.lesson001.demo13.applicationcontextaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceB implements ApplicationContextAware { //@1

    public void say(){
        ServiceA serviceA = this.getServiceA();//@2
        System.out.println("this:"+this+",serviceA:"+ serviceA);
    }

    public ServiceA getServiceA() {
        return this.context.getBean(ServiceA.class);//@3
    }

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

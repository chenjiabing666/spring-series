package com.javacode2018.lesson002.test19.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MainConfig1 {
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource result = new ResourceBundleMessageSource();
        //可以指定国家化配置文件的位置，格式：路径/文件名称,注意文件名称为不包【语言_国家.properties】含这部分
        result.setBasenames("com/javacode2018/lesson002/demo19/message");
        return result;
    }
}

package com.javacode2018.lesson002.test19.demo2;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MainConfig2 {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource result = new ReloadableResourceBundleMessageSource();
        result.setBasenames("com/javacode2018/lesson002/demo19/message");
        //设置缓存时间1000毫秒
        result.setCacheMillis(1000);
        return result;
    }
}

package com.javacode2018.lesson001.demo26.test14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig14 {
    @Bean
    public Service1 service1() {
        return new Service1();
    }

    @Bean
    public Service2 service2() {
        return new Service2();
    }

    @Bean
    public Service3 service3() {
        Service3 service3 = new Service3();
        service3.setService1(this.service1()); //@1
        service3.setService2(this.service2()); //@2
        return service3;
    }
}

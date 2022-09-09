package com.javacode2018.mybatis;

import com.javacode2018.mybatis.module1.Module1SpringConfig;
import com.javacode2018.mybatis.module2.Module2SpringConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Module1SpringConfig.class, Module2SpringConfig.class})
public class MainConfig {
}

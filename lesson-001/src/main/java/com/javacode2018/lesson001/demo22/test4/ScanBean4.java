package com.javacode2018.lesson001.demo22.test4;

import com.javacode2018.lesson001.demo22.test3.MyBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        useDefaultFilters = false, //不启用默认过滤器
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = IService.class)
        })
public class ScanBean4 {
}

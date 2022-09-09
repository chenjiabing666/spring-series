package com.javacode2018.lesson001.demo24.test4;

import com.javacode2018.lesson001.demo24.test3.module1.CompontentScanModule1;
import com.javacode2018.lesson001.demo24.test3.module2.CompontentScanModule2;
import org.springframework.context.annotation.Import;

/**
 * 通过@Import导入ImportBeanDefinitionRegistrar接口实现类
 */
@Import({MyImportBeanDefinitionRegistrar.class})
public class MainConfig4 {
}

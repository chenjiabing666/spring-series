package com.javacode2018.lesson001.demo23.test3;

import org.springframework.context.annotation.Import;

@Import({ImportSelector1.class, ConfigBean1.class, ConfigBean2.class})
public class ConfigMain {
}

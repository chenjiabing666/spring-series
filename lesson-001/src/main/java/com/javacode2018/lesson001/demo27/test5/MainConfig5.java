package com.javacode2018.lesson001.demo27.test5;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ImportResource;

@Configurable
@ImportResource("classpath:/com/javacode2018/lesson001/demo27/test5/beans*.xml")
public class MainConfig5 {
}

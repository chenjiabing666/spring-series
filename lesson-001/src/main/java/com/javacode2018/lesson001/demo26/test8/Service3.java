package com.javacode2018.lesson001.demo26.test8;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tag2")
public class Service3 implements IService {
}

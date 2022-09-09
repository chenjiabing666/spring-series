package com.javacode2018.springjunit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //@1
@ContextConfiguration(classes = {MainConfig.class}) //@2
public class MainConfigTest {

    @Autowired
    private String name;

    @Autowired
    private int age;

    @Test
    public void nameTest() {
        System.out.println(this.name);
        Assert.assertEquals("陈某java", this.name);
    }

    @Test
    public void ageTest() {
        System.out.println(this.age);
        Assert.assertEquals(30, this.age);
    }
}

package com.javacode2018.junit.demo1;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {
    @Test
    public void max() throws Exception {
        int result = MathUtils.max(1, 2, 3);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, 3);
    }
}
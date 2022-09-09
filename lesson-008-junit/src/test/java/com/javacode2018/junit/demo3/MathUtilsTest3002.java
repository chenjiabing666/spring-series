package com.javacode2018.junit.demo3;

import com.javacode2018.junit.demo1.MathUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MathUtilsTest3002 {
    @Test
    public void max() throws Exception {
        int result = MathUtils.max(100, 99, 200);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, 200);
    }

    @Test
    public void min() throws Exception {
        int result = MathUtils.min(1, -1, 10);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, -1);
    }
}

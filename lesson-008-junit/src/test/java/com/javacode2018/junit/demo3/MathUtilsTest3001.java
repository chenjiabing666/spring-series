package com.javacode2018.junit.demo3;

import com.javacode2018.junit.demo1.MathUtils;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest3001 {
    @Test
    public void max() throws Exception {
        int result = MathUtils.max(1, 2, 3);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, 3);
    }

    @Test
    public void min() throws Exception {
        int result = MathUtils.min(1, 2, 3);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, 1);
    }
}

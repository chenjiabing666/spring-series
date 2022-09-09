package com.javacode2018.junit.demo2;

import com.javacode2018.junit.demo1.MathUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MathUtilsTest2 {
    @Test
    public void max() throws Exception {
        int result = MathUtils.max(1, 2, 3);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, 1);
    }

    @Test
    public void min() throws Exception {
        int result = MathUtils.min(1, 2, 3);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(result, 3);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MathUtilsTest2.class);

        System.out.println("失败用例个数:" + result.getFailures().size());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
        System.out.println("运行测试用例个数:" + result.getRunCount());
        System.out.println("运行测试用例总耗时(ms):" + result.getRunTime());
        System.out.println("测试用例是否都成功了：" + result.wasSuccessful());
    }
}

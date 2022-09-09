package com.javacode2018.springjunit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MainConfigTest.class);
        System.out.println("-----------------");
        System.out.println("运行测试用例个数:" + result.getRunCount());
        System.out.println("失败用例个数:" + result.getFailures().size());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
        System.out.println("运行测试用例总耗时(ms):" + result.getRunTime());
        System.out.println("测试用例是否都成功了：" + result.wasSuccessful());

    }

}

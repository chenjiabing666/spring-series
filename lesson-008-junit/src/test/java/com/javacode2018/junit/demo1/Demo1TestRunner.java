package com.javacode2018.junit.demo1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Demo1TestRunner {
    public static void main(String[] args) {
        //使用JUnitCore.runClasses方法传入测试用例的类，然后获取测试用例的运行结果
        Result result = JUnitCore.runClasses(MathUtilsTest.class);
        //获取失败的用例
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
        //获取所有测试用例是否执行成功
        System.out.println(result.wasSuccessful());
    }
}

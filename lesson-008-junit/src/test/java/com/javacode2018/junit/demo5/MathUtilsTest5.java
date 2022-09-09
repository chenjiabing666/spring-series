package com.javacode2018.junit.demo5;

import com.javacode2018.junit.demo1.MathUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class MathUtilsTest5 {

    public static class TestData {
        int[] testData;//测试数据
        int expectedValue;//预期的结果

        public TestData(int[] testData, int expectedValue) {
            this.testData = testData;
            this.expectedValue = expectedValue;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "testData=" + Arrays.toString(testData) +
                    ", expectedValue=" + expectedValue +
                    '}';
        }
    }

    private TestData testData;

    @Parameterized.Parameters
    public static List<TestData> initTestData() {
        System.out.println("initTestData()");
        //key：期望的结果，value：max方法需要测试的数据
        List<TestData> result = new ArrayList<>();
        result.add(new TestData(new int[]{1, 2, 3}, 3));
        result.add(new TestData(new int[]{100, 99, 80}, 100));
        result.add(new TestData(new int[]{30, -1, 100}, 100));
        return result;
    }

    public MathUtilsTest5(TestData testData) {
        System.out.println("MathUtilsTest5构造器:" + testData);
        this.testData = testData;
    }

    @Test
    public void maxTest() throws Throwable {
        System.out.println(this.hashCode() + ",maxTest():" + this.testData);
        int result = MathUtils.max(this.testData.testData);
        //判断测试结果和我们期望的结果是否一致
        Assert.assertEquals(this.testData.expectedValue, result);
        System.out.println("###################");
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MathUtilsTest5.class);
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

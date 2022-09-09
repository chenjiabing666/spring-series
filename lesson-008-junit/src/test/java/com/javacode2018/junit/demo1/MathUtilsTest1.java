package com.javacode2018.junit.demo1;

public class MathUtilsTest1 {
    public static void main(String[] args) {
        testMax();
        testMin();
    }

    public static void testMax() {
        int result = MathUtils.max(1, 2, 3);
        if (result != 3) {
            System.out.println(String.format("max 方法有问题，期望结果是3，实际结果是%d", result));
        }
    }

    public static void testMin() {
        int result = MathUtils.min(1, 2, 3);
        if (result != 1) {
            System.out.println(String.format("min 方法有问题，期望结果是3，实际结果是%d", result));
        }
    }
}

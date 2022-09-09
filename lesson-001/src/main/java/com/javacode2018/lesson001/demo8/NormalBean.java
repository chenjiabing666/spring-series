package com.javacode2018.lesson001.demo8;

public class NormalBean {
    public interface IService{} //@1
    public static class ServiceA implements IService{} //@2
    public static class ServiceB implements IService{} //@3
}
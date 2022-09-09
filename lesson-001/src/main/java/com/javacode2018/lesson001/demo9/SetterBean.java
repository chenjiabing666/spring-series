package com.javacode2018.lesson001.demo9;

import java.util.Collection;
import java.util.List;

public class SetterBean {
    public interface IService {} //@1

    public static class ServiceA implements IService {} //@2

    public static class ServiceB implements IService {} //@3

    private IService service;

    public void setService(IService service) {
        this.service = service;
    }
    public void setService(Collection<IService> service) {
        System.out.println(service);
    }

    @Override
    public String toString() {
        return "SetterBean{" +
                "service=" + service +
                '}';
    }
}
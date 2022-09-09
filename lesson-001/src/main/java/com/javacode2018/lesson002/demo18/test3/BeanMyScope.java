package com.javacode2018.lesson002.demo18.test3;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

/**
 * @see MyScope 作用域的实现
 */
public class BeanMyScope implements Scope {

    public static final String SCOPE_MY = "my";

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("BeanMyScope >>>>>>>>> get:" + name);
        return objectFactory.getObject();
    }

    @Nullable
    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Nullable
    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Nullable
    @Override
    public String getConversationId() {
        return null;
    }
}

package com.javacode2018.lesson001.demo18;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class UserAnnotation11Test {
    @Test
    public void m1() {
        for (Annotation annotation : UseAnnotation11.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m2() {
        TypeVariable<Class<UseAnnotation11>>[] typeParameters = UseAnnotation11.class.getTypeParameters();
        for (TypeVariable<Class<UseAnnotation11>> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName() + "变量类型注解信息：");
            Annotation[] annotations = typeParameter.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
    }

    @Test
    public void m3() throws NoSuchFieldException {
        Field nameField = UseAnnotation11.class.getDeclaredField("name");
        for (Annotation annotation : nameField.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m4() throws NoSuchFieldException, ClassNotFoundException {
        Field field = UseAnnotation11.class.getDeclaredField("map");
        Type genericType = field.getGenericType();
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();

        AnnotatedType annotatedType = field.getAnnotatedType();
        AnnotatedType[] annotatedActualTypeArguments = ((AnnotatedParameterizedType) annotatedType).getAnnotatedActualTypeArguments();
        int i = 0;
        for (AnnotatedType actualTypeArgument : annotatedActualTypeArguments) {
            Type actualTypeArgument1 = actualTypeArguments[i++];
            System.out.println(actualTypeArgument1.getTypeName() + "类型上的注解如下：");
            for (Annotation annotation : actualTypeArgument.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }

    @Test
    public void m5() {
        Constructor<?> constructor = UseAnnotation11.class.getConstructors()[0];
        for (Annotation annotation : constructor.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m6() throws NoSuchMethodException {
        Method method = UseAnnotation11.class.getMethod("m1", String.class);
        for (Annotation annotation : method.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void m7() throws NoSuchMethodException {
        Method method = UseAnnotation11.class.getMethod("m1", String.class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println(String.format("参数%s上的注解如下:", parameter.getName()));
            for (Annotation annotation : parameter.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }
}

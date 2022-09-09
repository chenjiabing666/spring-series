package com.javacode2018.aop.demo9;

import com.javacode2018.aop.demo9.test1.Aspect1;
import com.javacode2018.aop.demo9.test1.Service1;
import com.javacode2018.aop.demo9.test10.AspectTest10;
import com.javacode2018.aop.demo9.test10.S10;
import com.javacode2018.aop.demo9.test11.AspectTest11;
import com.javacode2018.aop.demo9.test11.S11;
import com.javacode2018.aop.demo9.test12.AspectTest12;
import com.javacode2018.aop.demo9.test12.S12;
import com.javacode2018.aop.demo9.test13.BeanService;
import com.javacode2018.aop.demo9.test13.MainConfig13;
import com.javacode2018.aop.demo9.test2.AspectTest2;
import com.javacode2018.aop.demo9.test2.C2;
import com.javacode2018.aop.demo9.test3.AspectTest3;
import com.javacode2018.aop.demo9.test3.I1;
import com.javacode2018.aop.demo9.test3.Service3;
import com.javacode2018.aop.demo9.test4.AspectTest4;
import com.javacode2018.aop.demo9.test5.AspectTest5;
import com.javacode2018.aop.demo9.test5.Service5;
import com.javacode2018.aop.demo9.test6.Ann6;
import com.javacode2018.aop.demo9.test6.AspectTest6;
import com.javacode2018.aop.demo9.test6.S6;
import com.javacode2018.aop.demo9.test7.Ann7;
import com.javacode2018.aop.demo9.test7.AspectTest7;
import com.javacode2018.aop.demo9.test7.S7;
import com.javacode2018.aop.demo9.test8.AspectTest8;
import com.javacode2018.aop.demo9.test8.S8;
import com.javacode2018.aop.demo9.test9.AspectTest9;
import com.javacode2018.aop.demo9.test9.S9;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ClassUtils;

public class AopTest9 {
    /**
     * execution：用于匹配方法执行的连接点
     */
    @Test
    public void test1() {
        try {
            //对应目标对象
            Service1 target = new Service1();
            //创建AspectJProxyFactory对象
            AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
            //设置被代理的目标对象
            proxyFactory.setTarget(target);
            //设置标注了@Aspect注解的类
            proxyFactory.addAspect(Aspect1.class);
            //生成代理对象
            Service1 proxy = proxyFactory.getProxy();
            //使用代理对象
            proxy.m1(null);
            proxy.m2();
        } catch (Exception e) {
        }
    }

    /**
     * within(类型)：目标对象target的类型是否和within中指定的类型匹配
     */
    @Test
    public void test2() {
        C2 target = new C2();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest2.class);

        C2 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    /**
     * this(类型全限定名)：通过aop创建的代理对象的类型是否和this中指定的类型匹配；
     * 注意判断的目标是代理对象；
     * this中使用的表达式必须是类型全限定名，不支持通配符。
     */
    @Test
    public void test3() {
        Service3 target = new Service3();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        //获取目标对象上的接口列表
        Class<?>[] allInterfaces = ClassUtils.getAllInterfaces(target);
        //设置需要代理的接口
        proxyFactory.setInterfaces(allInterfaces);
        proxyFactory.addAspect(AspectTest3.class);
        //获取代理对象
        Object proxy = proxyFactory.getProxy();
        //调用代理对象的方法
        ((I1) proxy).m1();

        System.out.println("proxy是否是jdk动态代理对象：" + AopUtils.isJdkDynamicProxy(proxy));
        System.out.println("proxy是否是cglib代理对象：" + AopUtils.isCglibProxy(proxy));
        //判断代理对象是否是Service3类型的
        System.out.println(Service3.class.isAssignableFrom(proxy.getClass()));
    }

    /**
     * target(类型全限定名)：判断目标对象的类型是否和指定的类型匹配；
     * 注意判断的是目标对象的类型；
     * 表达式必须是类型全限定名，不支持通配符。
     */
    @Test
    public void test4() {
        Service3 target = new Service3();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest4.class);
        //获取代理对象
        Object proxy = proxyFactory.getProxy();
        //调用代理对象的方法
        ((I1) proxy).m1();
        //判断target对象是否是Service3类型的
        System.out.println(Service3.class.isAssignableFrom(target.getClass()));
    }

    /**
     * args：匹配方法参数类想
     */
    @Test
    public void test5() {
        Service5 target = new Service5();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest5.class);
        Service5 proxy = proxyFactory.getProxy();
        //调用2次，第一次传入一个String类型的，第二次传入一个int类型的，看看效果
        proxy.m1("陈某");
        proxy.m1(100);
    }

    /**
     * @target：目标类上有指定的注解
     */
    @Test
    public void test6() {
        S6 target = new S6();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest6.class);
        S6 proxy = proxyFactory.getProxy();
        proxy.m1();
        System.out.println("目标类上是否有 @Ann6 注解：" + (target.getClass().getAnnotation(Ann6.class) != null));
    }

    @Test
    public void test7() {
        S7 target = new S7();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest7.class);
        S7 proxy = proxyFactory.getProxy();
        proxy.m1();
        System.out.println("目标类上是否有 @Ann7 注解：" + (target.getClass().getAnnotation(Ann7.class) != null));
    }

    @Test
    public void test8() {
        S8 target = new S8();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest8.class);
        S8 proxy = proxyFactory.getProxy();
        proxy.m1(null);
        proxy.m2("陈某java", null, 100);
    }

    /**
     * @within(注解类型)：匹配指定注解的类中定义的所有方法
     */
    @Test
    public void test9() {
        S9 target = new S9();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest9.class);
        S9 proxy = proxyFactory.getProxy();
        proxy.m1();
    }

    /**
     * @within(注解类型)：匹配指定注解的类中定义的所有方法
     */
    @Test
    public void test10() {
        S10 target = new S10();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest10.class);
        S10 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    /**
     * @within(注解类型)：匹配指定注解的类中定义的所有方法
     */
    @Test
    public void test11() {
        S11 target = new S11();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest11.class);
        S11 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    /**
     * @annotation(注解类型)：被调用的方法上有指定的注解
     */
    @Test
    public void test12() {
        S12 target = new S12();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest12.class);
        S12 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
        proxy.m4();
    }

@Test
public void test13() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig13.class);
    //从容器中获取beanService1
    BeanService beanService1 = context.getBean("beanService1", BeanService.class);
    beanService1.m1();
    //从容器中获取beanService2
    BeanService beanService2 = context.getBean("beanService2", BeanService.class);
    beanService2.m1();
}
}

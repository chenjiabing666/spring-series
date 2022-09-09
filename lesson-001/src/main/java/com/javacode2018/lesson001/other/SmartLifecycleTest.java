package com.javacode2018.lesson001.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
public class SmartLifecycleTest {

    @Bean
    public String name() {
        log.info("name()");
        return "陈某Java";
    }

    @Bean
    public SmartLifecycle1 smartLifecycl1() {
        return new SmartLifecycle1();
    }

    @Bean
    public SmartLifecycle2 smartLifecycl2() {
        return new SmartLifecycle2();
    }

    public static void main(String[] args) {
        log.info("spring容器启动");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SmartLifecycleTest.class);
        log.info("spring容器启动完毕");
        context.close();
        log.info("spring容器已关闭");
    }

    @Slf4j
    public static class SmartLifecycle1 implements SmartLifecycle {

        @Override
        public int getPhase() {
            return 10;
        }

        @Override
        public void start() {
            log.info("start");
        }

        @Override
        public void stop() {
            log.info("stop");
        }

        @Override
        public boolean isRunning() {
            log.info("isRunning");
            return true;
        }
    }

    @Slf4j
    public static class SmartLifecycle2 implements SmartLifecycle {

        @Override
        public int getPhase() {
            return 9;
        }

        @Override
        public void start() {
            log.info("start");
        }

        @Override
        public void stop() {
            log.info("stop");
        }

        @Override
        public boolean isRunning() {
            log.info("isRunning");
            return true;
        }
    }
}

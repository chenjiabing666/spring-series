package com.javacode2018.scheduled.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@ComponentScan
@EnableScheduling //在spring容器中启用定时任务的执行
public class MainConfig2 {
    @Bean
    public ScheduledExecutorService taskScheduler() {
        //设置需要并行执行的任务数量
        int corePoolSize = 20;
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
}

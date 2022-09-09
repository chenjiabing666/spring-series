package com.javacode2018.async.demo5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync //@0：启用方法异步调用
@ComponentScan
public class MainConfig5 {

    //@1：值业务线程池bean名称
    public static final String RECHARGE_EXECUTORS_BEAN_NAME = "rechargeExecutors";
    //@2：提现业务线程池bean名称
    public static final String CASHOUT_EXECUTORS_BEAN_NAME = "cashOutExecutors";

    /**
     * @3：充值的线程池，线程名称以recharge-thread-开头
     * @return
     */
    @Bean(RECHARGE_EXECUTORS_BEAN_NAME)
    public Executor rechargeExecutors() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        //线程名称前缀
        executor.setThreadNamePrefix("recharge-thread-");
        return executor;
    }

    /**
     * @4: 充值的线程池，线程名称以cashOut-thread-开头
     *
     * @return
     */
    @Bean(CASHOUT_EXECUTORS_BEAN_NAME)
    public Executor cashOutExecutors() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        //线程名称前缀
        executor.setThreadNamePrefix("cashOut-thread-");
        return executor;
    }
}

package com.javacode2018.tx.demo8;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement //开启spring事务管理功能
@Configuration //指定当前类是一个spring配置类
@ComponentScan //开启bean扫描注册
public class MainConfig8 {
    //定义数据源1，连接数据库：ds1
    @Bean
    public DataSource dataSource1() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ds1?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        dataSource.setInitialSize(5);
        return dataSource;
    }

    //定义一个jdbcTemplate1
    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //定义事务管理器transactionManager1
    @Bean
    public PlatformTransactionManager transactionManager1(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //定义jdbcTemplate2
    @Bean
    public JdbcTemplate jdbcTemplate2(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //定义事务管理器transactionManager2
    @Bean
    public PlatformTransactionManager transactionManager2(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

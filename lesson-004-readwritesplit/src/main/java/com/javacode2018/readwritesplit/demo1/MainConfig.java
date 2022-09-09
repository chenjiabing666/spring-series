package com.javacode2018.readwritesplit.demo1;

import com.javacode2018.readwritesplit.base.DsType;
import com.javacode2018.readwritesplit.base.EnableReadWrite;
import com.javacode2018.readwritesplit.base.ReadWriteDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableReadWrite
@Configuration
@ComponentScan
public class MainConfig {
    //主库数据源
    @Bean
    public DataSource masterDs() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javacode2018_master?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        dataSource.setInitialSize(5);
        return dataSource;
    }

    //从库数据源
    @Bean
    public DataSource slaveDs() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javacode2018_slave?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        dataSource.setInitialSize(5);
        return dataSource;
    }

    //读写分离路由数据源
    @Bean
    public ReadWriteDataSource dataSource() {
        ReadWriteDataSource dataSource = new ReadWriteDataSource();
        //设置主库为默认的库
        dataSource.setDefaultTargetDataSource(this.masterDs());
        //设置多个目标库
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DsType.MASTER, this.masterDs());
        targetDataSources.put(DsType.SLAVE, this.slaveDs());
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    //JdbcTemplate，dataSource为上面定义的注入读写分离的数据源
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //定义事务管理器，dataSource为上面定义的注入读写分离的数据源
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

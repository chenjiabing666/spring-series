package com.javacode2018.readwritesplit.demo1;

import com.javacode2018.readwritesplit.base.DsType;
import com.javacode2018.readwritesplit.base.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService implements IService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public String getUserNameById(long id, DsType dsType) {
        String sql = "select name from t_user where id=?";
        List<String> list = this.jdbcTemplate.queryForList(sql, String.class, id);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    //这个insert方法会走主库，内部的所有操作都会走主库
    @Transactional
    public void insert(long id, String name) {
        System.out.println(String.format("插入数据{id:%s, name:%s}", id, name));
        this.jdbcTemplate.update("insert into t_user (id,name) values (?,?)", id, name);
        String userName = this.userService.getUserNameById(id, DsType.SLAVE);
        System.out.println("查询结果：" + userName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test1(long id, DsType dsType) {
        {
            String sql = "select name from t_user where id=?";
            List<String> list = this.jdbcTemplate.queryForList(sql, String.class, id);
            System.out.println(list);
        }
        this.userService.test2(id, DsType.MASTER);
        {
            String sql = "select name from t_user where id=?";
            List<String> list = this.jdbcTemplate.queryForList(sql, String.class, id);
            System.out.println(list);
        }
    }

    //propagation为REQUIRES_NEW，开启一个新的事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test2(long id, DsType dsType) {
        String sql = "select name from t_user where id=?";
        List<String> list = this.jdbcTemplate.queryForList(sql, String.class, id);
        System.out.println(list);
    }


}
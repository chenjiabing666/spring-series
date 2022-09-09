package com.javacode2018.jdbctemplate.demo1;

import com.javacode2018.jdbctemplate.util.DataSourceUtils;
import org.junit.Test;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Demo1Test {
    @Test
    public void test0() {
        //1.创建数据源DataSource
        DataSource dataSource = DataSourceUtils.getDataSource();
        //2.创建JdbcTemplate，new JdbcTemplate(dataSource)
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //3.调用JdbcTemplate的方法操作db，如增删改查
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(maps);
    }

    @Test
    public void test1() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int updateRows = jdbcTemplate.update("INSERT INTO t_user (name) VALUE ('maven系列')");
        System.out.println("影响行数：" + updateRows);
    }

    @Test
    public void test2() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int updateRows = jdbcTemplate.update("INSERT INTO t_user (name) VALUE (?)", "mybatis系列");
        System.out.println("影响行数：" + updateRows);
    }

    @Test
    public void test3() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int updateRows = jdbcTemplate.update("INSERT INTO t_user (name) VALUE (?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, "mysql系列");
            }
        });
        System.out.println("影响行数：" + updateRows);
    }

    @Test
    public void test4() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO t_user (name) VALUE (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowCount = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //手动创建PreparedStatement，注意第二个参数：Statement.RETURN_GENERATED_KEYS
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "获取自增列的值");
                return ps;
            }
        }, keyHolder);
        System.out.println("新记录id：" + keyHolder.getKey().intValue());
    }

    @Test
    public void test5() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Object[]> list = Arrays.asList(
                new Object[]{"刘德华"},
                new Object[]{"郭富城"},
                new Object[]{"张学友"},
                new Object[]{"黎明"});
        int[] updateRows = jdbcTemplate.batchUpdate("INSERT INTO t_user (name) VALUE (?)", list);
        for (int updateRow : updateRows) {
            System.out.println(updateRow);
        }
    }

    @Test
    public void test6() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String name = jdbcTemplate.queryForObject("select name from t_user where id = ?", String.class, 114);
        System.out.println(name);
    }

    @Test
    public void test7() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String name = jdbcTemplate.queryForObject("select name from t_user where id = ?", String.class, 0);
        System.out.println(name);
    }

    @Test
    public void test8() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //<T> List<T> queryForList(String sql, Class<T> elementType);
        List<String> list1 = jdbcTemplate.queryForList("select name from t_user where id>131", String.class);
        System.out.println("list1:" + list1);

        //<T> List<T> queryForList(String sql, Class<T> elementType, @Nullable Object... args);
        List<String> list2 = jdbcTemplate.queryForList("select name from t_user where id>?", String.class, 131);
        System.out.println("list2:" + list2);

        //<T> List<T> queryForList(String sql, Object[] args, Class<T> elementType);
        List<String> list3 = jdbcTemplate.queryForList("select name from t_user where id>?", new Object[]{131}, String.class);
        System.out.println("list3:" + list3);

        //<T> List<T> queryForList(String sql, Object[] args, int[] argTypes, Class<T> elementType);
        List<String> list4 = jdbcTemplate.queryForList("select name from t_user where id>?", new Object[]{131}, new int[]{java.sql.Types.INTEGER}, String.class);
        System.out.println("list4:" + list4);
    }

    @Test
    public void test9() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id = ?";
        //查询id为34的用户信息
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Nullable
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(1));
                return user;
            }
        }, 134);
        System.out.println(user);
    }

    @Test
    public void test10() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id = ?";
        //查询id为34的用户信息
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 134);
        System.out.println(user);
    }

    @Test
    public void test11() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id>?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, 130);
        System.out.println(maps);
    }

    @Test
    public void test12() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id>?";
        List<User> maps = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Nullable
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(1));
                return user;
            }
        }, 130);
        System.out.println(maps);
    }

    @Test
    public void test13() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id>?";
        List<User> maps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), 130);
        System.out.println(maps);
    }
}

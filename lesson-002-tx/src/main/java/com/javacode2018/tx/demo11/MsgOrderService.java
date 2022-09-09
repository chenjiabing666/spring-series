package com.javacode2018.tx.demo11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Component
public class MsgOrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 插入消息订单
     *
     * @param ref_type
     * @param ref_id
     * @return
     */
    @Transactional
    public MsgOrderModel insert(Integer ref_type, String ref_id) {
        MsgOrderModel msgOrderModel = MsgOrderModel.builder().ref_type(ref_type).ref_id(ref_id).build();
        //插入消息
        this.jdbcTemplate.update("insert into t_msg_order (ref_type,ref_id) values (?,?)",
                ref_type,
                ref_id
        );
        //获取消息订单id
        msgOrderModel.setId(this.jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class));
        return msgOrderModel;
    }

    /**
     * 根据消息id获取消息
     *
     * @param id
     * @return
     */
    public MsgOrderModel getById(Long id) {
        List<MsgOrderModel> list = this.jdbcTemplate.query("select * from t_msg_order where id = ? limit 1", new BeanPropertyRowMapper<MsgOrderModel>(MsgOrderModel.class), id);
        return Objects.nonNull(list) && !list.isEmpty() ? list.get(0) : null;
    }

}

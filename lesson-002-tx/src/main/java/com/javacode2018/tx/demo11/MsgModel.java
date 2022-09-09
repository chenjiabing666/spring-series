package com.javacode2018.tx.demo11;

import lombok.*;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MsgModel {
    private Long id;
    //消息内容
    private String msg;
    //消息订单id
    private Long msg_order_id;
    //消息状态,0:待投递，1：已发送，2：取消发送
    private Integer status;
}

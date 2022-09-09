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
public class MsgOrderModel {
    private Long id;
    //关联业务类型
    private Integer ref_type;
    //关联业务id（ref_type & ref_id 唯一）
    private String ref_id;
}

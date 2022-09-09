package com.javacode2018.tx.demo11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公众号：码猿技术专栏，工作10年的前阿里P8分享Java、算法、数据库方面的技术干货！
 * <a href="https://www.java-fmaily.cn">个人博客</a>
 */
@Component
public class UserService1 {
    @Autowired
    private UserService userService;

    @Autowired
    private MsgSender msgSender;

    //嵌套事务案例
    @Transactional
    public void nested() {
        this.msgSender.send("消息1", 2, "1");
        //registerRequiresNew事务传播属性是REQUIRES_NEW:会在一个新事务中运行
        this.userService.registerRequiresNew(1L, "张三");
        //registerFail事务传播属性是默认的，会在当前事务中运行，registerFail弹出异常会导致当前事务回滚
        this.userService.registerFail(2L, "李四");
    }
}

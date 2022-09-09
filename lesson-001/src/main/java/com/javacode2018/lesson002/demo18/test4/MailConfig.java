package com.javacode2018.lesson002.demo18.test4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 邮件配置信息
 */
@Component
@RefreshScope
public class MailConfig {

    @Value("${mail.username}")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "MailConfig{" +
                "username='" + username + '\'' +
                '}';
    }
}

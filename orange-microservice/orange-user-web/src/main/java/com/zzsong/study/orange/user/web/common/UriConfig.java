package com.zzsong.study.orange.user.web.common;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by zzsong on 2017/10/25.
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "uri")
public class UriConfig {
    // 登录地址
    private String login = "http://localhost:8021/login.html";

    /**
     * 登录地址
     */
    public String getLogin() {
        return login;
    }

    /**
     * 登录地址
     */
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

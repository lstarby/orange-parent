package com.zzsong.study.orange.sso.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zzsong on 2017/10/16.
 */
@Component
@ConfigurationProperties(prefix = "config")
public class Config {
    private String userSession; // userSession在redis中的key头
    private Long sessionExpire; // session存活时间
    private String tokenKey; // 单点登录cookie的key

    /**
     * userSession在redis中的key头
     */
    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    /**
     * session存活时间,单位秒
     */
    public Long getSessionExpire() {
        return sessionExpire;
    }

    public void setSessionExpire(Long sessionExpire) {
        this.sessionExpire = sessionExpire;
    }

    /**
     * 单点登录cookie的key
     */
    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}

package com.zzsong.study.orange.sso.common;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by zzsong on 2017/10/25.
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "mobileCode")
public class MobileCodeConfig {
    // 验证码请求间隔时间,秒
    private long interval = 60;
    // 验证码存活时间,秒
    private long survive = 180;
    // 验证码最大保存数量
    private int maxCount = 3;
    // 验证码长度
    private int codeLength = 4;

    /**
     * 验证码请求间隔时间,秒
     */
    public long getInterval() {
        return interval;
    }

    /**
     * 验证码请求间隔时间,秒
     */
    public void setInterval(long interval) {
        this.interval = interval;
    }

    /**
     * 验证码存活时间,秒
     */
    public long getSurvive() {
        return survive;
    }

    /**
     * 验证码存活时间,秒
     */
    public void setSurvive(long survive) {
        this.survive = survive;
    }

    /**
     * 验证码最大保存数量
     */
    public int getMaxCount() {
        return maxCount;
    }

    /**
     * 验证码最大保存数量
     */
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 验证码长度
     */
    public int getCodeLength() {
        return codeLength;
    }

    /**
     * 验证码长度
     */
    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

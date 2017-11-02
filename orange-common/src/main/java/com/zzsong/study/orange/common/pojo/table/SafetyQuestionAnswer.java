package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 安全问题答案
 * Created by zzsong on 2017/10/23.
 */
@Getter
@Setter
public class SafetyQuestionAnswer implements Serializable {
    /**
     * 安全问题答案主键
     */
    private String questionAnswerId;
    /**
     * 用户表主键
     */
    private String userId;
    /**
     * 问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

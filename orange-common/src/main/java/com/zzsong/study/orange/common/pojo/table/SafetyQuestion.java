package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 安全问题
 * Created by zzsong on 2017/10/23.
 */
public class SafetyQuestion implements Serializable {
    /**
     * 问题ID
     */
    private Integer questionId;
    /**
     * 问题
     */
    private String question;

    /**
     * 问题ID
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 问题ID
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 问题
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

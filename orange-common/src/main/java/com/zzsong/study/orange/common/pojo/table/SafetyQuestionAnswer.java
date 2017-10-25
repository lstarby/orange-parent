package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 安全问题答案
 * Created by zzsong on 2017/10/23.
 */
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

    /**
     * 安全问题答案主键
     */
    public String getQuestionAnswerId() {
        return questionAnswerId;
    }

    /**
     * 安全问题答案主键
     */
    public void setQuestionAnswerId(String questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }

    /**
     * 用户表主键
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户表主键
     */
    public void setUserId(String userId) {
        this.userId = userId;
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

    /**
     * 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

package com.zzsong.study.orange.common.pojo.table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 安全问题
 * Created by zzsong on 2017/10/23.
 */
@Getter
@Setter
@ToString
public class SafetyQuestion implements Serializable {
    /**
     * 问题ID
     */
    private Integer questionId;
    /**
     * 问题
     */
    private String question;

}

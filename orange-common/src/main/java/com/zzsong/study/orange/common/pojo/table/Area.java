package com.zzsong.study.orange.common.pojo.table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 区
 * Created by zzsong on 2017/10/30.
 */
@Getter
@Setter
@ToString
public class Area implements Serializable {
    /**
     * 区编码
     */
    private int code;
    /**
     * 区名称
     */
    private String name;
    /**
     * 所属市编码
     */
    private int parentCode;
}

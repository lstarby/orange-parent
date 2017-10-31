package com.zzsong.study.orange.common.pojo.table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 市
 * Created by zzsong on 2017/10/30.
 */
@Getter
@Setter
@ToString
public class City implements Serializable {
    /**
     * 市编码
     */
    private int code;
    /**
     * 市名称
     */
    private String name;
    /**
     * 所属省编码
     */
    private int parentCode;
}

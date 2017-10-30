package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 街道
 * Created by zzsong on 2017/10/30.
 */
public class Street implements Serializable {
    /**
     * 街道编码
     */
    private int code;
    /**
     * 街道名称
     */
    private String name;
    /**
     * 所属区编码
     */
    private int parentCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentCode() {
        return parentCode;
    }

    public void setParentCode(int parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

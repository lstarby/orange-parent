package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 省
 * Created by zzsong on 2017/10/30.
 */
public class Province implements Serializable {
    /**
     * 省编码
     */
    private int code;
    /**
     * 省名称
     */
    private String name;

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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

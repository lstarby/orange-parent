package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 区
 * Created by zzsong on 2017/10/30.
 */
@Getter
@Setter
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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

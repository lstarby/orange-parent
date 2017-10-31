package com.zzsong.study.orange.common.pojo.table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 省
 * Created by zzsong on 2017/10/30.
 */
@Getter
@Setter
@ToString
public class Province implements Serializable {
    /**
     * 省编码
     */
    private int code;
    /**
     * 省名称
     */
    private String name;
}

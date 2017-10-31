package com.zzsong.study.orange.common.pojo.table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 收货地址
 * Created by zzsong on 2017/10/23.
 */
@Getter
@Setter
@ToString
public class ReceivingAddress implements Serializable {
    /**
     * 收货地址id
     */
    private String receiveAddressId;
    /**
     * 用户表主键
     */
    private String userId;
    /**
     * 收货人姓名
     */
    private String receiveName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String region;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 是否默认收货地址, 0:否 1:是
     */
    private Integer isDefault;
}

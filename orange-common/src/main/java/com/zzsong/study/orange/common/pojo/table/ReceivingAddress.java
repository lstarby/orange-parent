package com.zzsong.study.orange.common.pojo.table;

import java.io.Serializable;

/**
 * 收货地址
 * Created by zzsong on 2017/10/23.
 */
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

    /**
     * 收货地址id
     */
    public String getReceiveAddressId() {
        return receiveAddressId;
    }

    /**
     * 收货地址id
     */
    public void setReceiveAddressId(String receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
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
     * 收货人姓名
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * 收货人姓名
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    /**
     * 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区
     */
    public String getRegion() {
        return region;
    }

    /**
     * 区
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 详细地址
     */
    public String getDetailedAddress() {
        return detailedAddress;
    }

    /**
     * 详细地址
     */
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    /**
     * 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 是否默认收货地址, 0:否 1:是
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 是否默认收货地址, 0:否 1:是
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}

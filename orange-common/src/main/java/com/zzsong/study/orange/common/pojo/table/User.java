package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * Created by zzsong on 2017/10/13.
 */
public class User implements Serializable {
    /**
     * 用户主键
     */
    private String userId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 性别 0:女 1:男 2:其他 3:保密
     */
    private Integer gender;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号状态, 0:正常 1:停用
     */
    private Integer accountState;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态时间
     */
    private Date stateTime;
    /**
     * 会员等级
     */
    private Integer membershipGrade;
    /**
     * 身份证号码
     */
    private String idCardNumber;
    /**
     * 支付密码
     */
    private String paymentPassword;

    /**
     * 用户主键
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户主键
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性别 0:女 1:男 2:其他 3:保密
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别 0:女 1:男 2:其他 3:保密
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 账号状态, 0:正常 1:停用
     */
    public Integer getAccountState() {
        return accountState;
    }

    /**
     * 账号状态, 0:正常 1:停用
     */
    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 状态时间
     */
    public Date getStateTime() {
        return stateTime;
    }

    /**
     * 状态时间
     */
    public void setStateTime(Date stateTime) {
        this.stateTime = stateTime;
    }

    /**
     * 会员等级
     */
    public Integer getMembershipGrade() {
        return membershipGrade;
    }

    /**
     * 会员等级
     */
    public void setMembershipGrade(Integer membershipGrade) {
        this.membershipGrade = membershipGrade;
    }

    /**
     * 身份证号码
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * 身份证号码
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    /**
     * 支付密码
     */
    public String getPaymentPassword() {
        return paymentPassword;
    }

    /**
     * 支付密码
     */
    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

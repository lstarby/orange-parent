package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zzsong on 2017/10/13.
 */
public class User implements Serializable{
    private String id;
    private String password;
    private String email;
    private String phone;
    private String userName;
    private Integer accountState;
    private Date createTime;
    private Date stateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStateTime() {
        return stateTime;
    }

    public void setStateTime(Date stateTime) {
        this.stateTime = stateTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

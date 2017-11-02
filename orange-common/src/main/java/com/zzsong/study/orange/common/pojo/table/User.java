package com.zzsong.study.orange.common.pojo.table;

import com.alibaba.fastjson.JSON;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * Created by zzsong on 2017/10/13.
 */
@Getter
@Setter
@Accessors(chain = true)
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
     * 是否实名认证, 1:是 0:否
     */
    private Integer isRealAuthentication;
    /**
     * 用户头像地址
     */
    private String headPortrait;


    /**
     * 格式化的生日{yyyy-MM-dd}
     * 前端需要
     */
    private String formattedBirthday;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

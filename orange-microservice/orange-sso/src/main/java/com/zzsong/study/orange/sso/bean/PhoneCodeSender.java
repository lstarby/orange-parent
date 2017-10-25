package com.zzsong.study.orange.sso.bean;

import com.zzsong.study.orange.common.pojo.Result;

/**
 * Created by zzsong on 2017/10/24.
 */
public interface PhoneCodeSender {
    /**
     * 发送短信验证码, 验证码平台自动生成验证码, 并将验证码返回
     * Result.status 200代表成功
     * Result.msg 错误信息
     * Result.data 发送的短信验证码
     *
     * @param phone 手机号码
     * @return Result<String>
     */
    Result<String> send(String phone);

    /**
     * 发送自定义验证码
     * Result.status 200代表成功
     * Result.msg 错误信息
     * Result.data 发送的短信验证码
     *
     * @param phone 手机号码
     * @param code  自定义验证码
     * @return Result<String>
     */
    Result<String> send(String phone, String code);
}

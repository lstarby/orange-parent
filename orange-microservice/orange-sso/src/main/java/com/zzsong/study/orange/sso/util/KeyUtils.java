package com.zzsong.study.orange.sso.util;

/**
 * Created by zzsong on 2017/10/25.
 */
public class KeyUtils {

    /**
     * 生成短信验证码在redis中的key
     *
     * @param phone 手机号
     * @param code  验证码
     * @return key
     */
    public static String createMobileCodeKey(String phone, String code) {
        return "orangesso:sendMobileCode:" + phone + "-" + code;
    }
}

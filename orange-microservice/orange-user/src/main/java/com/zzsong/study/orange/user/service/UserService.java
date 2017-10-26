package com.zzsong.study.orange.user.service;


import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;

/**
 * Created by zzsong on 2017/10/13.
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param user User Object
     * @return Result<String>
     */
    Result<String> addUser(User user);

    /**
     * 通过账号密码查询用户
     *
     * @param user (password+(userid | phone | email))
     * @return Result<User>
     */
    Result<User> getUser(User user);

    /**
     * 检验邮箱是否可用
     *
     * @param email 邮箱
     * @return 200:可用,邮箱不存在 400:不可用,邮箱已存在
     */
    Result<String> checkEmail(String email);

    /**
     * 检验手机是否可用
     *
     * @param phone 手机号码
     * @return 200:可用,手机不存在 400:不可用,手机已存在
     */
    Result<String> checkPhone(String phone);
}

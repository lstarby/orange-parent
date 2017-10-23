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
     * @param account  账号(邮箱 手机)
     * @param password 密码
     * @return Result<User>
     */
    Result<User> getUser(String account, String password);
}

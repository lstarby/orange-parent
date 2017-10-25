package com.zzsong.study.orange.user.service.impl;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.common.util.MD5Hash;
import com.zzsong.study.orange.user.mapper.UserMapper;
import com.zzsong.study.orange.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zzsong on 2017/10/13.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserMapper userMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection") // 加这个注解让IDE 不报: Could not autowire
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result<String> addUser(User user) {
        String password = user.getPassword();
        int i = 0;
        try {
            user.setPassword(MD5Hash.md5(password));
            i = userMapper.addUser(user);
        } catch (Exception e) {
            logger.info("insert user to database throw exception:{}", e.getMessage());
        }
        if (i > 0) {
            return Result.ok("ok", user.getUserId());
        } else {
            return Result.err("新增账号失败!");
        }
    }

    @Override
    public Result<User> getUser(String account, String password) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            logger.debug("用户名或密码不可为空!");
            return Result.err("用户名或密码不可为空!");
        }
        List<User> users = userMapper.getUser(account, MD5Hash.md5(password));
        if (users.size() == 0) {
            logger.debug("用户名或密码错误!");
            return Result.err("用户名或密码错误!");
        }
        User u = users.get(0);
        u.setPassword(null);
        return Result.ok("ok", u);
    }

    @Override
    public Result<String> checkEmail(String email) {
        if (StringUtils.isBlank(email)) {
            logger.debug("邮箱不可为空!");
            return Result.err("邮箱不可为空!");
        }
        User user = new User();
        user.setEmail(email);
        int i = userMapper.checkAccount(user);
        if (i > 0) {
            return Result.err("该邮箱已存在!");
        } else {
            return Result.ok();
        }
    }

    @Override
    public Result<String> checkPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            logger.debug("手机号码不可为空!");
            return Result.err("手机号码不可为空!");
        }
        User user = new User();
        user.setPhone(phone);
        int i = userMapper.checkAccount(user);
        if (i > 0) {
            return Result.err("该手机号已存在!");
        } else {
            return Result.ok();
        }
    }
}

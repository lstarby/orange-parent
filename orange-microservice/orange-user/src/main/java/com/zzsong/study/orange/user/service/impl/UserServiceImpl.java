package com.zzsong.study.orange.user.service.impl;

import com.zzsong.study.orange.user.pojo.LogObject;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.common.util.MD5Hash;
import com.zzsong.study.orange.user.mapper.UserMapper;
import com.zzsong.study.orange.user.service.UserService;
import com.zzsong.study.orange.user.util.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zzsong on 2017/10/13.
 */
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

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
            log.info("insert user to database throw exception:{}", e.getMessage());
        }
        if (i > 0) {
            return Result.ok("ok", user.getUserId());
        } else {
            return Result.err("新增账号失败!");
        }
    }

    @Override
    public Result<User> getUser(User user) {
        String password = user.getPassword();
        String userId = user.getUserId();
        String phone = user.getPhone();
        String email = user.getEmail();
        if (StringUtils.isBlank(password)) {
            log.debug("密码不可为空!");
            return Result.err("账号或密码不可为空!");
        }
        if (StringUtils.isBlank(userId)
                && StringUtils.isBlank(phone)
                && StringUtils.isBlank(email)) {
            log.debug("账号不可为空!");
            return Result.err("账号或密码不可为空!");
        }
        user.setPassword(MD5Hash.md5(password));
        List<User> users = userMapper.getUser(user);
        if (users.size() == 0) {
            log.debug("用户名或密码错误!");
            return Result.err("用户名或密码错误!");
        }
        User u = users.get(0);
        u.setPassword(null);
        return Result.ok("ok", u);
    }

    @Override
    public Result<String> checkEmail(String email) {
        if (StringUtils.isBlank(email)) {
            log.debug("邮箱不可为空!");
            return Result.err("邮箱不可为空!");
        }
        User user = new User();
        user.setEmail(email);
        int i = userMapper.checkUser(user);
        if (i > 0) {
            return Result.err("该邮箱已存在!");
        } else {
            return Result.ok();
        }
    }

    @Override
    public Result<String> checkPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            log.debug("手机号码不可为空!");
            return Result.err("手机号码不可为空!");
        }
        User user = new User();
        user.setPhone(phone);
        int i = userMapper.checkUser(user);
        if (i > 0) {
            return Result.err("该手机号已存在!");
        } else {
            return Result.ok();
        }
    }

    @Override
    public Result<String> changePassword(User user, String newPassword) {
        int i = userMapper.changePassword(user, newPassword);
        if (i == 1) {
            return Result.ok();
        }
        if (i > 1) {
            log.warn("changePassword修改条数大于1!");
            TransactionUtil.rollback();
            LogObject.OrangeLog log = LogObject.get();
            log.setLogLevel(1);
            log.getErrMsg().add("changePassword修改条数大于1!");
        }
        return Result.err("密码修改失败!");
    }

    @Override
    public Result<String> updateUserByUserId(User user) {
        if (user == null || user.getUserId() == null) {
            log.debug("user或userId为空!");
            return Result.err("user或userId为空!");
        }
        int i = userMapper.updateUserByUserId(user);
        if (i == 0) {
            return Result.err("用户信息修改失败!");
        }
        return Result.ok();
    }
}

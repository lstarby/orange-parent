package com.zzsong.study.orange.sso.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.sso.common.Config;
import com.zzsong.study.orange.sso.feign.UserFeignClient;
import com.zzsong.study.orange.sso.common.RspCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * Created by zzsong on 2017/10/13.
 */
@RestController
@RefreshScope
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final Config config;

    private final UserFeignClient userFeignClient;


    @Autowired
    public UserController(UserFeignClient userFeignClient, Config config) {
        this.userFeignClient = userFeignClient;
        this.config = config;
    }

    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }

    @PostMapping("/register")
    public Result<String> register(User user, String code) {
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();
        if (StringUtils.isBlank(phone) && StringUtils.isBlank(email)) {
            logger.debug("账号不可为空");
            return Result.err("账号不可为空");
        }
        if (StringUtils.isNotBlank(phone)) {
            if (StringUtils.isBlank(code)) {
                logger.debug("手机验证码不可为空");
                return Result.err("手机验证码不可为空");
            }
            Result<String> checkPhone = userFeignClient.checkPhone(phone);
            if (RspCode.SUCC_200.equals(checkPhone.getStatus())) {
                return Result.err("该手机号已被使用");
            }
        }
        if (StringUtils.isBlank(password)) {
            logger.debug("密码不可为空");
            return Result.err("密码不可为空");
        }
        Result<String> result = userFeignClient.addUser(user);
        Integer status = result.getStatus();
        if (RspCode.SUCC_200.equals(status)) {
            return Result.ok("注册成功");
        } else {
            return Result.err("注册失败, 请稍后再试!");
        }
    }

    @PostMapping("/login")
    public Result<String> login(String account, String password,HttpSession session) {
        logger.debug("login : account = {} , password = {}", account, password);
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            logger.debug("用户名或密码为空");
            return Result.err("用户名或密码为空");
        }
        Result<User> result = userFeignClient.getUser(account, password);
        logger.debug("result = {}", result.toString());
        if (result.getStatus() != 200) {
            logger.debug("登录验证失败 , msg = {}", result.getMsg());
            return Result.err(result.getMsg());
        }
        User user = result.getData();
        session.setAttribute("user", user);
        String token = session.getId();
        return Result.ok("ok", token);
    }
}
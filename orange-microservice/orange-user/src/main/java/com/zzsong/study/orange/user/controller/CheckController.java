package com.zzsong.study.orange.user.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.util.IOUtils;
import com.zzsong.study.orange.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by zzsong on 2017/10/15.
 */
@RestController
public class CheckController {
    private static Logger logger = LoggerFactory.getLogger(CheckController.class);

    private final UserService userService;

    @Autowired
    public CheckController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 判断邮箱是否可用
     *
     * @param email 邮箱
     * @return 200:可用,邮箱不存在 400:不可用,邮箱已存在
     */
    @PostMapping("/checkEmail")
    public Result<String> checkEmail(@RequestParam String email) {
        logger.debug("checkPhone : email = {}", email);
        Result<String> result = userService.checkEmail(email);
        logger.debug("checkPhone : result = {}", result.toString());
        return result;
    }

    /**
     * 判断手机号码是否可用
     *
     * @param phone 手机号码
     * @return 200:可用,手机不存在 400:不可用,邮箱已存在
     */
    @PostMapping("/checkPhone")
    public Result<String> checkPhone(@RequestParam String phone) {
        logger.debug("checkPhone: phone = {}", phone);
        Result<String> result = userService.checkPhone(phone);
        logger.debug("checkPhone : result = {}", result.toString());
        return result;
    }
}

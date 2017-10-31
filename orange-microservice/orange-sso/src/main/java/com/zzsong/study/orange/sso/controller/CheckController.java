package com.zzsong.study.orange.sso.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.sso.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by zzsong on 2017/10/23.
 */
@RestController
public class CheckController {
    private static Logger logger = LoggerFactory.getLogger(CheckController.class);

    private final UserFeignClient userFeignClient;

    @Autowired
    public CheckController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    /**
     * 判断邮箱是否可用
     *
     * @param email 邮箱
     * @return 200:可用,邮箱不存在 400:不可用,邮箱已存在
     */
    @PostMapping("/checkEmail")
    public Result<String> checkEmail(String email, HttpSession session) {
        String sessionId = session.getId();
        Result<String> result = userFeignClient.checkEmail(email, sessionId);
        logger.debug("checkEmail: email = {}, result = {}, msg = {}", email, result.getStatus(), result.getMsg());
        return result;
    }

    /**
     * 判断手机号码是否可用
     *
     * @param phone 手机号码
     * @return 200:可用,手机不存在 400:不可用,手机已存在
     */
    @PostMapping("/checkPhone")
    public Result<String> checkPhone(String phone, HttpSession session) {
        String sessionId = session.getId();
        Result<String> result = userFeignClient.checkPhone(phone, sessionId);
        logger.debug("checkPhone: phone = {}, result = {}, msg = {}", phone, result.getStatus(), result.getMsg());
        return result;
    }
}

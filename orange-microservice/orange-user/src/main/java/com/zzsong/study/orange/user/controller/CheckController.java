package com.zzsong.study.orange.user.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zzsong on 2017/10/15.
 */
@RestController
public class CheckController {

    private final UserService userService;

    @Autowired
    public CheckController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 判断邮箱是否已存在
     *
     * @param email 邮箱
     * @return 200:存在 204:不存在
     */
    @PostMapping("/checkEmail")
    public Result<String> checkEmail(@RequestBody String email) {
        return Result.ok();
    }

    /**
     * 判断手机号码是否已存在
     *
     * @param phone 手机号码
     * @return 200:存在 204:不存在
     */
    @PostMapping("/checkPhone")
    public Result<String> checkPhone(@RequestBody String phone) {
        return Result.ok();
    }
}

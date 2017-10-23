package com.zzsong.study.orange.user.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zzsong on 2017/10/13.
 */
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 新增用户
     *
     * @param user User
     * @return Result<String>
     */
    @PostMapping("/addUser")
    public Result<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 查询用户
     *
     * @param account  账号(邮箱 手机)
     * @param password 密码
     * @return Result<User>
     */
    @PostMapping("/getUser")
    public Result<User> getUser(@RequestParam String account,
                                @RequestParam String password) {
        return userService.getUser(account, password);
    }
}

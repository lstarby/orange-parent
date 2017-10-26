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
        logger.debug("addUser : user = {}", user.toString());
        Result<String> result = userService.addUser(user);
        logger.debug("addUser : result = {}", result.toString());
        return result;
    }

    /**
     * 查询用户
     *
     * @param user (password+(userid | phone | email))
     * @return Result<User>
     */
    @PostMapping("/getUser")
    public Result<User> getUser(@RequestBody User user) {
        logger.debug("getUser : user = {}", user.toString());
        Result<User> result = userService.getUser(user);
        logger.debug("getUser : result = {}", result.toString());
        return result;
    }

    /**
     * 修改密码
     *
     * @param user ()
     * @return Result<String>
     */
    @PostMapping("changePassword")
    public Result<String> changePassword(@RequestBody User user) {
        return Result.ok();
    }
}

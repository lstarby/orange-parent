package com.zzsong.study.orange.user.controller;

import com.zzsong.study.orange.common.constants.RspCode;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.user.mongo.LogRepository;
import com.zzsong.study.orange.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;


/**
 * Created by zzsong on 2017/10/13.
 */
@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    private LogRepository logRepository;

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
        log.debug("addUser : user = {}", user.toString());
        Result<String> result = userService.addUser(user);
        log.debug("addUser : result = {}", result.toString());
        return result;
    }

    /**
     * 查询用户
     *
     * @param user (password+(userid | phone | email))
     * @return Result<User>
     */
    @PostMapping("/getUser")
    public Result<User> getUser(@RequestBody User user) throws SocketException {
        log.debug("getUser : user = {}", user.toString());
        Result<User> result = userService.getUser(user);
        log.debug("getUser : result = {}", result.toString());
        return result;
    }

    /**
     * 修改密码
     *
     * @param user ()
     * @return Result<String>
     */
    @PostMapping("changePassword")
    public Result<String> changePassword(@RequestBody User user,
                                         @RequestParam String newPassword) {
        log.debug("changePassword : user = {} , newPassword = {}", user.toString(), newPassword);
        Result<String> result = userService.changePassword(user, newPassword);
        if (!RspCode.SUCC_200.equals(result.getStatus())) {
            return Result.err("密码修改失败, 请确认原密码是否正确!");
        }
        return Result.ok();
    }


    /**
     * 判断邮箱是否可用
     *
     * @param email 邮箱
     * @return 200:可用,邮箱不存在 400:不可用,邮箱已存在
     */
    @PostMapping("/checkEmail")
    public Result<String> checkEmail(@RequestParam String email) {
        log.debug("checkPhone : email = {}", email);
        Result<String> result = userService.checkEmail(email);
        log.debug("checkPhone : result = {}", result.toString());
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
        log.debug("checkPhone: phone = {}", phone);
        Result<String> result = userService.checkPhone(phone);
        log.debug("checkPhone : result = {}", result.toString());
        return result;
    }

    @PostMapping("/updateUserByUserId")
    public Result<String> updateUserByUserId(@RequestBody User user) {
        log.debug("updateUserByUserId : user = {}", user.toString());
        Result<String> result = userService.updateUserByUserId(user);
        log.debug("updateUserByUserId : result = {}", result.toString());
        return result;
    }
}

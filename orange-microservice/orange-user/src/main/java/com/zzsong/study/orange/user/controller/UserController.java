package com.zzsong.study.orange.user.controller;

import com.zzsong.study.orange.common.constants.RspCode;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.Province;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.user.mongo.LogRepository;
import com.zzsong.study.orange.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.util.List;


/**
 * Created by zzsong on 2017/10/13.
 */
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

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
    public Result<User> getUser(@RequestBody User user) throws SocketException {
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
    public Result<String> changePassword(@RequestBody User user,
                                         @RequestParam String newPassword) {
        logger.debug("changePassword : user = {} , newPassword = {}", user.toString(), newPassword);
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

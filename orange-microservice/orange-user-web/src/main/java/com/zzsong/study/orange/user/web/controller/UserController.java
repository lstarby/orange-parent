package com.zzsong.study.orange.user.web.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.user.web.pojo.LogObject;
import com.zzsong.study.orange.user.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by zzsong on 2017/10/13.
 */
@Slf4j
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 上传头像
     *
     * @param file    头像文件
     * @param session 回话信息
     * @return Result<String>
     */
    @PostMapping("/uploadHeadPortrait")
    public Result<String> uploadHeadPortrait(@RequestParam("file") MultipartFile file, HttpSession session) {
        Result<String> result = userService.uploadHeadPortrait(file, session);
        log.debug("uploadHeadPortrait : result = {}", result.toString());
        return result;
    }

    @PostMapping("/updateUserInformation")
    public Result<User> updateUserInformation(User user, HttpSession session) {
        log.debug("updateUserInformation : user = {}", user.toString());
        Result<User> result = userService.updateUserInformation(user, session);
        log.debug("updateUserInformation result = {}", result.toString());
        return result;
    }

    @PostMapping("/changePassword")
    public Result<String> changePassword(String password, String newPassword, HttpSession session) {
        Result<String> result = userService.changePassword(password, newPassword, session);
        log.debug("changePassword result = {}", result.toString());
        return result;
    }
}
package com.zzsong.study.orange.user.web.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.user.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/uploadHeadPortrait")
    @ResponseBody
    public Result<String> uploadHeadPortrait(@RequestParam("file") MultipartFile file, HttpSession session) {
        Result<String> result = userService.uploadHeadPortrait(file, session);
        log.debug("uploadHeadPortrait : result = {}", result.toString());
        return result;
    }

}
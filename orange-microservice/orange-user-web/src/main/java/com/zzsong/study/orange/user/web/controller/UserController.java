package com.zzsong.study.orange.user.web.controller;

import com.zzsong.study.orange.user.web.feign.UserFeignClient;
import com.zzsong.study.orange.user.web.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zzsong on 2017/10/13.
 */
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserFeignClient userFeignClient;

    private final RedisService redisService;

    @Autowired
    public UserController(UserFeignClient userFeignClient, RedisService redisService) {
        this.userFeignClient = userFeignClient;
        this.redisService = redisService;
    }

}
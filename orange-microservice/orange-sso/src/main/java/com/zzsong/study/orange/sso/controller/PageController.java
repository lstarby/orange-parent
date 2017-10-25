package com.zzsong.study.orange.sso.controller;

import com.zzsong.study.orange.sso.common.MobileCodeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zzsong on 2017/10/15.
 */
@Controller
public class PageController {
    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MobileCodeConfig mobileCodeConfig;

    @RequestMapping(path = {"login", "login.html"})
    public String login() {
        return "login";
    }

    @RequestMapping(path = {"register", "register.html"})
    public String register() {
        return "register";
    }

    @RequestMapping("/404.html")
    public String err404() {
        logger.debug("mobileCodeConfig={}", mobileCodeConfig.toString());
        return "404";
    }

    @RequestMapping("/500.html")
    public String err500() {
        return "500";
    }

}

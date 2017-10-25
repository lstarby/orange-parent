package com.zzsong.study.orange.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zzsong on 2017/10/15.
 */
@Controller
public class PageController {

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
        return "404";
    }

    @RequestMapping("/500.html")
    public String err500() {
        return "500";
    }

}

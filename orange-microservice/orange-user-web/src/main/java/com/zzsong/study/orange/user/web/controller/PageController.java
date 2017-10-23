package com.zzsong.study.orange.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zzsong on 2017/10/14.
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }
}

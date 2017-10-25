package com.zzsong.study.orange.sso.controller;

import com.zzsong.study.orange.sso.bean.PhoneCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zzsong on 2017/10/15.
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page, HttpSession session) {
        return page;
    }

}

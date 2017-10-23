package com.zzsong.study.orange.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zzsong on 2017/10/14.
 */
@Controller
public class CodeController {

    @RequestMapping("/getPhoneCode")
    @ResponseBody
    public String registerPhoneCode(HttpSession session, String phone) {
        String s = "1234";
        session.setAttribute("phoneCode", s);
        session.setAttribute("phone", phone);
        return s;
    }
}

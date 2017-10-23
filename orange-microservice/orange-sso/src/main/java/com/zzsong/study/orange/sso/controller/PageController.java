package com.zzsong.study.orange.sso.controller;

import com.zzsong.study.orange.common.pojo.table.User;
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
        Object o = session.getAttribute("user");
        if (o != null) {
            User u = (User) o;
            System.out.println(u.toString());
        }
        return page;
    }

}

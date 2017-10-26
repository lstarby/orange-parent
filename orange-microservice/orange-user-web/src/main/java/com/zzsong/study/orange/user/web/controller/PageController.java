package com.zzsong.study.orange.user.web.controller;

import com.zzsong.study.orange.common.constants.SessionConstants;
import com.zzsong.study.orange.common.pojo.table.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zzsong on 2017/10/14.
 */
@Controller
public class PageController {
    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(path = {"/index.html", "/index"})
    public String index(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "index";
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

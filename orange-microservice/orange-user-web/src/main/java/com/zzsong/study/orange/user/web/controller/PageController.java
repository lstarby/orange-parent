package com.zzsong.study.orange.user.web.controller;

import com.zzsong.study.orange.user.web.common.UriConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zzsong on 2017/10/14.
 */
@Controller
public class PageController {
    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private UriConfig uriConfig;

    @RequestMapping(path = {"/index.html", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/404.html")
    public String err404() {
        logger.debug("uriConfig={}", uriConfig.toString());
        return "404";
    }

    @RequestMapping("/500.html")
    public String err500() {
        return "500";
    }
}

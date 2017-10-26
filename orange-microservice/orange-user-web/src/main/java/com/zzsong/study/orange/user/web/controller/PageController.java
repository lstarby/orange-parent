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

    /**
     * 用户中心首页
     */
    @RequestMapping(path = {"/index.html", "/index"})
    public String index(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "index";
    }

    /**
     * 收货地址
     */
    @RequestMapping(path = {"/address.html", "/address"})
    public String address() {
        return "address";
    }

    @RequestMapping(path = {"/bill.html", "/bill"})
    public String bill() {
        return "bill";
    }

    @RequestMapping(path = {"/billlist.html", "/billlist"})
    public String billlist() {
        return "billlist";
    }

    @RequestMapping(path = {"/bindphone.html", "/bindphone"})
    public String bindphone() {
        return "bindphone";
    }

    @RequestMapping(path = {"/blog.html", "/blog"})
    public String blog() {
        return "blog";
    }

    @RequestMapping(path = {"/bonus.html", "/bonus"})
    public String bonus() {
        return "bonus";
    }

    @RequestMapping(path = {"/change.html", "/change"})
    public String change() {
        return "change";
    }

    @RequestMapping(path = {"/collection.html", "/collection"})
    public String collection() {
        return "collection";
    }

    @RequestMapping(path = {"/comment.html", "/comment"})
    public String comment() {
        return "comment";
    }

    @RequestMapping(path = {"/commentlist.html", "/commentlist"})
    public String commentlist() {
        return "commentlist";
    }

    @RequestMapping(path = {"/coupon.html", "/coupon"})
    public String coupon() {
        return "coupon";
    }

    @RequestMapping(path = {"/email.html", "/email"})
    public String email() {
        return "email";
    }

    @RequestMapping(path = {"/foot.html", "/foot"})
    public String foot() {
        return "foot";
    }

    @RequestMapping(path = {"/idcard.html", "/idcard"})
    public String idcard() {
        return "idcard";
    }

    @RequestMapping(path = {"/information.html", "/information"})
    public String information() {
        return "information";
    }

    @RequestMapping(path = {"/logistics.html", "/logistics"})
    public String logistics() {
        return "logistics";
    }

    @RequestMapping(path = {"/news.html", "/news"})
    public String news() {
        return "news";
    }

    @RequestMapping(path = {"/order.html", "/order"})
    public String order() {
        return "order";
    }

    @RequestMapping(path = {"/orderinfo.html", "/orderinfo"})
    public String orderinfo() {
        return "orderinfo";
    }

    @RequestMapping(path = {"/password.html", "/password"})
    public String password() {
        return "password";
    }

    @RequestMapping(path = {"/question.html", "/question"})
    public String question() {
        return "question";
    }

    @RequestMapping(path = {"/record.html", "/record"})
    public String record() {
        return "record";
    }

    @RequestMapping(path = {"/refund.html", "/refund"})
    public String refund() {
        return "refund";
    }

    @RequestMapping(path = {"/safety.html", "/safety"})
    public String safety() {
        return "safety";
    }

    @RequestMapping(path = {"/setpay.html", "/setpay"})
    public String setpay() {
        return "setpay";
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

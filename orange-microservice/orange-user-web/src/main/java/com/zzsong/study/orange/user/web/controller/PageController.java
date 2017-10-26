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
    public String address(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "address";
    }

    /**
     * 账单
     */
    @RequestMapping(path = {"/bill.html", "/bill"})
    public String bill(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "bill";
    }

    /**
     * 账单明细
     */
    @RequestMapping(path = {"/billlist.html", "/billlist"})
    public String billlist(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "billlist";
    }

    /**
     * 绑定手机
     */
    @RequestMapping(path = {"/bindphone.html", "/bindphone"})
    public String bindphone(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "bindphone";
    }

    /**
     * blog
     */
    @RequestMapping(path = {"/blog.html", "/blog"})
    public String blog(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "blog";
    }

    /**
     * 红包
     */
    @RequestMapping(path = {"/bonus.html", "/bonus"})
    public String bonus(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "bonus";
    }

    /**
     * 退换货管理
     */
    @RequestMapping(path = {"/change.html", "/change"})
    public String change(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "change";
    }

    /**
     * 我的收藏
     */
    @RequestMapping(path = {"/collection.html", "/collection"})
    public String collection(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "collection";
    }

    /**
     * 评价管理
     */
    @RequestMapping(path = {"/comment.html", "/comment"})
    public String comment(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "comment";
    }

    /**
     * 发表评论
     */
    @RequestMapping(path = {"/commentlist.html", "/commentlist"})
    public String commentlist(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "commentlist";
    }

    /**
     * 优惠券
     */
    @RequestMapping(path = {"/coupon.html", "/coupon"})
    public String coupon(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "coupon";
    }

    /**
     * 绑定邮箱
     */
    @RequestMapping(path = {"/email.html", "/email"})
    public String email(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "email";
    }

    /**
     * 我的足迹
     */
    @RequestMapping(path = {"/foot.html", "/foot"})
    public String foot(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "foot";
    }

    /**
     * 实名认证
     */
    @RequestMapping(path = {"/idcard.html", "/idcard"})
    public String idcard(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "idcard";
    }

    /**
     * 个人资料
     */
    @RequestMapping(path = {"/information.html", "/information"})
    public String information(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "information";
    }

    /**
     * 物流跟踪
     */
    @RequestMapping(path = {"/logistics.html", "/logistics"})
    public String logistics(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "logistics";
    }

    /**
     * 我的消息
     */
    @RequestMapping(path = {"/news.html", "/news"})
    public String news(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "news";
    }

    /**
     * 收货地址
     */
    @RequestMapping(path = {"/order.html", "/order"})
    public String order(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "order";
    }

    /**
     * 订单详情
     */
    @RequestMapping(path = {"/orderinfo.html", "/orderinfo"})
    public String orderinfo(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "orderinfo";
    }

    /**
     * 修改密码
     */
    @RequestMapping(path = {"/password.html", "/password"})
    public String password(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "password";
    }

    /**
     * 设置安全问题
     */
    @RequestMapping(path = {"/question.html", "/question"})
    public String question(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "question";
    }

    /**
     * 钱款去向
     */
    @RequestMapping(path = {"/record.html", "/record"})
    public String record(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "record";
    }

    /**
     * 退换货申请
     */
    @RequestMapping(path = {"/refund.html", "/refund"})
    public String refund(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "refund";
    }

    /**
     * 账户安全
     */
    @RequestMapping(path = {"/safety.html", "/safety"})
    public String safety(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
        return "safety";
    }

    /**
     * 支付密码
     */
    @RequestMapping(path = {"/setpay.html", "/setpay"})
    public String setpay(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        map.addAttribute(SessionConstants.SESSION_USER_ATTR, user);
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

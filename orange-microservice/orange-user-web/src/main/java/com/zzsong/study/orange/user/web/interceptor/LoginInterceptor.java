package com.zzsong.study.orange.user.web.interceptor;

import com.zzsong.study.orange.common.constants.SessionConstants;
import com.zzsong.study.orange.common.util.SessionUtils;
import com.zzsong.study.orange.user.web.common.UriConfig;
import com.zzsong.study.orange.user.web.service.RedisService;
import com.zzsong.study.orange.user.web.util.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截未登录用户, 跳转到单点登录页面
 * Created by zzsong on 2017/10/25.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private UriConfig uriConfig;

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        String sessionKey = CookieUtils.getCookieValue(httpServletRequest,
                SessionConstants.COOKIE_SESSION_KEY);
        String key = SessionUtils.createRedisSessionKey(sessionKey);
        String userHashKey = SessionUtils.createUserHashKey();
        Object huser = redisService.hmGet(key, userHashKey);
        String loginUrl = uriConfig.getLogin();
        if (huser == null) {
            httpServletResponse.sendRedirect(loginUrl);
            logger.debug("LoginInterceptor 拦截请求, 用户未登录, Redirect to {}", loginUrl);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}

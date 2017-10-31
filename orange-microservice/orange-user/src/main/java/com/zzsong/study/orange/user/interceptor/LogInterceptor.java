package com.zzsong.study.orange.user.interceptor;

import com.zzsong.study.orange.common.constants.SessionConstants;
import com.zzsong.study.orange.user.pojo.LogObject;
import com.zzsong.study.orange.user.mongo.LogRepository;
import com.zzsong.study.orange.user.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.SocketException;
import java.util.Date;

/**
 * 日志拦截器
 * Created by zzsong on 2017/10/25.
 */
public class LogInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Autowired
    private LogRepository logRepository;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        String sessionId = httpServletRequest.getHeader(SessionConstants.SESSION_ID_HEADER);
        String ipAddr = IpUtils.getIpAddr(httpServletRequest);
        long time = new Date().getTime();
        String localIpAddr = null;
        try {
            localIpAddr = IpUtils.getLocalIpAddr();
        } catch (SocketException e) {
            logger.error("获取本机ip失败 : {}", e.getMessage());
        }
        LogObject.OrangeLog log = LogObject.get();
        if (log == null) {
            logger.error("LogObject.get() return null!");
            return true;
        }
        log.setSessionId(sessionId);
        log.setReqUri(requestURI);
        log.setReqIp(ipAddr);
        log.setLocalIp(localIpAddr);
        log.setReqTime(time);
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
                                Object o, Exception e) {
        LogObject.OrangeLog log = LogObject.get();
        if (log != null) {
            int status = httpServletResponse.getStatus();
            long reqTime = log.getReqTime();
            long rspTime = new Date().getTime();
            long manageTime = rspTime - reqTime;
            log.setRspStatus(status);
            log.setManageTime(manageTime);
            log.setRspTime(rspTime);
            log.setCreatedAt(new Date());
            logRepository.insert(log);
            logger.debug("本次记录日志内容为: {}", log.toString());
            LogObject.remove();
        } else {
            logger.error("LogObject.get() return null");
        }
    }
}

package com.zzsong.study.orange.user.aop;

import com.zzsong.study.orange.user.pojo.LogObject;
import com.zzsong.study.orange.user.util.AopUtils;
import org.apache.ibatis.javassist.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzsong on 2017/10/26.
 */
@Component
@Aspect
public class WebControllerAop {

    private static Logger logger = LoggerFactory.getLogger(WebControllerAop.class);

    @Pointcut("execution(* com.zzsong.study.orange.user.controller..*.*(..))")
    public void executeService() {
    }

    @AfterReturning(value = "executeService()", returning = "rsp")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object rsp) {
        LogObject.OrangeLog log = LogObject.get();
        String clazzName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName(); //获取方法名称
        Object[] args = joinPoint.getArgs();//参数
        Map<String, Object> parameters = new HashMap<>();//获取被切参数名称及参数值
        try {
            parameters = AopUtils.getFieldsName(this.getClass(), clazzName, methodName, args);
        } catch (NotFoundException e) {
            String message = e.getMessage();
            logger.error("NotFoundException = {}", message);
            log.getErrMsg().add(message);
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            parameters.put(key, request.getParameter(key));
        }
//        log.setMethod(methodName);
        log.getRequestParams().putAll(parameters);
        log.setResponse(rsp);
    }

    @AfterThrowing(value = "executeService()", throwing = "e")
    public void doAfterThrowingAdvice(Exception e) {
        String message = e.getMessage();
        LogObject.OrangeLog log = LogObject.get();
        log.getErrMsg().add(message);
        log.setLogLevel(1);
    }

}

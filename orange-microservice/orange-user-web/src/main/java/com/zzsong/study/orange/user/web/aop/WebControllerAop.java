package com.zzsong.study.orange.user.web.aop;

import com.zzsong.study.orange.common.constants.AopConstants;
import com.zzsong.study.orange.user.web.pojo.LogObject;
import com.zzsong.study.orange.user.web.util.AopUtils;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
@Slf4j
public class WebControllerAop {

    @Pointcut("execution(* com.zzsong.study.orange.user.web.controller..*.*(..))")
    public void executeService() {
    }

    @AfterReturning(value = "executeService()", returning = "rsp")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object rsp) {
        LogObject.OrangeLog orangeLog = LogObject.get();
        String clazzName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName(); //获取方法名称
        Object[] args = joinPoint.getArgs();//参数
        Map<String, Object> parameters = new HashMap<>();//获取被切参数名称及参数值
        try {
            parameters = AopUtils.getFields(this.getClass(), clazzName,
                    methodName, args, AopConstants.ACCEPT_TYPES);
        } catch (NotFoundException e) {
            String message = e.getMessage();
            log.error("NotFoundException = {}", message);
            orangeLog.getErrMsg().add(message);
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            parameters.put(key, request.getParameter(key));
        }
        orangeLog.getRequestParams().putAll(parameters);
        orangeLog.setResponse(rsp);
    }

    @AfterThrowing(value = "executeService()", throwing = "e")
    public void doAfterThrowingAdvice(Exception e) {
        String message = e.getMessage();
        LogObject.OrangeLog orangeLog = LogObject.get();
        orangeLog.getErrMsg().add(message);
        orangeLog.setLogLevel(1);
    }

}

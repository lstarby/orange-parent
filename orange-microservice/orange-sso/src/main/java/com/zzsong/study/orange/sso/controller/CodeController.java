package com.zzsong.study.orange.sso.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.util.RandomUtils;
import com.zzsong.study.orange.sso.service.RedisService;
import com.zzsong.study.orange.sso.common.MobileCodeConfig;
import com.zzsong.study.orange.sso.util.KeyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Set;

/**
 * Created by zzsong on 2017/10/14.
 */
@Controller
public class CodeController {
    private static Logger logger = LoggerFactory.getLogger(CodeController.class);
    private final RedisService redisService;

    private final MobileCodeConfig mobileCodeConfig;

    @Autowired
    public CodeController(RedisService redisService, MobileCodeConfig mobileCodeConfig) {
        this.redisService = redisService;
        this.mobileCodeConfig = mobileCodeConfig;
    }

    @RequestMapping("/sendMobileCode")
    @ResponseBody
    public Result<String> sendMobileCode(String phone) {
        if (StringUtils.isBlank(phone)) {
            logger.debug("手机号码不可为空!");
            return Result.err("手机号码不可为空!");
        }
        Set values = redisService.values(KeyUtils.createMobileCodeKey(phone, "*"));
        long time = new Date().getTime();
        boolean b = true;
        long l = 0L;
        for (Object value : values) {
            l = (time - (long) value) / 1000;
            if (l < mobileCodeConfig.getInterval()) {
                logger.debug("验证码请求时间差过短, 差值为: {}秒", l);
                b = false;
                break;
            }
        }
        int size = values.size();
        logger.debug("手机号:{} 已获取验证码的数量: {}", phone, size);
        if (size >= mobileCodeConfig.getMaxCount() || !b) {
            return Result.err("验证码获取过于频繁,请" + (mobileCodeConfig.getInterval() - l) + "秒后再试!");
        }
        int code = RandomUtils.createRandomNumbeBySpecifiedLength(mobileCodeConfig.getCodeLength());
        logger.debug("sendMobileCode 生成的验证码为: {}", code);
        String key = KeyUtils.createMobileCodeKey(phone, String.valueOf(code));
        boolean ok = redisService.set(key, time, mobileCodeConfig.getSurvive());
        if (!ok) {
            logger.debug("sendMobileCode 验证码存储失败!");
            return Result.err("出现错误, 请稍后再试!");
        }
        return Result.ok();
    }
}

package com.zzsong.study.orange.user.web.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zzsong on 2017/10/18.
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static Logger logger = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        logger.info("fallback, User服务访问失败: {}", throwable.getMessage());
        return new UserFeignClient() {

        };
    }
}
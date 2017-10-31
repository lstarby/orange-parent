package com.zzsong.study.orange.sso.feign;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
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
        return new UserFeignClient() {

            @Override
            public Result<String> addUser(User user, String sessionId) {
                logger.info("fallback, User服务访问失败: {}", throwable.getMessage());
                return Result.err("User服务访问失败!");
            }

            @Override
            public Result<User> getUser(User user, String sessionId) {
                logger.info("fallback, User服务访问失败: {}", throwable.getMessage());
                return Result.err("User服务访问失败!");
            }

            @Override
            public Result<String> checkEmail(String email, String sessionId) {
                logger.info("fallback, User服务访问失败: {}", throwable.getMessage());
                return Result.err("User服务访问失败!");
            }

            @Override
            public Result<String> checkPhone(String phone, String sessionId) {
                logger.info("fallback, User服务访问失败: {}", throwable.getMessage());
                return Result.err("User服务访问失败!");
            }
        };
    }
}

package com.zzsong.study.orange.user.web.configure;

import com.zzsong.study.orange.user.web.service.RedisService;
import com.zzsong.study.orange.user.web.service.impl.RedisServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 集中管理依赖
 * Created by zzsong on 2017/10/25.
 */
@Configuration
public class BeanConfigure {

    @Bean
    public RedisService redisService(RedisTemplate redisTemplate) {
        return new RedisServiceImpl(redisTemplate);
    }
}

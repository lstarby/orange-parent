package com.zzsong.study.orange.sso.configure;

import com.zzsong.study.orange.sso.service.PhoneCodeSender;
import com.zzsong.study.orange.sso.service.RedisService;
import com.zzsong.study.orange.sso.service.impl.NetEasyPhoneCodeSender;
import com.zzsong.study.orange.sso.service.impl.RedisServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zzsong on 2017/10/25.
 */
@Configuration
public class BeanConfigure {

    @Bean
    public RedisService redisService(RedisTemplate redisTemplate) {
        return new RedisServiceImpl(redisTemplate);
    }

    @Bean
    public PhoneCodeSender phoneCodeSender(RestTemplate template) {
        return new NetEasyPhoneCodeSender(template);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

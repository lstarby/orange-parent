package com.zzsong.study.orange.sso.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by zzsong on 2017/10/17.
 */
@EnableRedisHttpSession(redisNamespace = "orange")
public class HttpSessionConfig {

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        // 修改cookie中sessionToken的key
        cookieSerializer.setCookieName("ORANGE-TOKEN");
        CookieHttpSessionStrategy cookieHttpSessionStrategy = new CookieHttpSessionStrategy();
        cookieHttpSessionStrategy.setCookieSerializer(cookieSerializer);

        return cookieHttpSessionStrategy;
    }
}

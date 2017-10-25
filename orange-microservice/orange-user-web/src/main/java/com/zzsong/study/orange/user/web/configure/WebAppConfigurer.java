package com.zzsong.study.orange.user.web.configure;

import com.zzsong.study.orange.user.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zzsong on 2017/10/25.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localInterceptor()).addPathPatterns("/seengene/**") 添加
//                .excludePathPatterns("/seengene/login") 排除
//                .excludePathPatterns("/seengene/logindo");
//    }
}

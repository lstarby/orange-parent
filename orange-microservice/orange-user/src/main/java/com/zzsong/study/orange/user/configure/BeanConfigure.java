package com.zzsong.study.orange.user.configure;

import com.zzsong.study.orange.user.mapper.AreaMapper;
import com.zzsong.study.orange.user.mapper.UserMapper;
import com.zzsong.study.orange.user.service.AreaService;
import com.zzsong.study.orange.user.service.UserService;
import com.zzsong.study.orange.user.service.impl.AreaServiceImpl;
import com.zzsong.study.orange.user.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 集中管理依赖
 * Created by zzsong on 2017/10/25.
 */
@Configuration
public class BeanConfigure {

    @Bean
    @SuppressWarnings("SpringJavaAutowiringInspection") // 加这个注解让IDE 不报: Could not autowire
    public UserService userService(UserMapper userMapper) {
        return new UserServiceImpl(userMapper);
    }

    @Bean
    @SuppressWarnings("SpringJavaAutowiringInspection") // 加这个注解让IDE 不报: Could not autowire
    public AreaService areaService(AreaMapper areaMapper) {
        return new AreaServiceImpl(areaMapper);
    }
}

package com.zzsong.study.orange.user.web;

import com.zzsong.study.orange.user.web.configure.LoadAdditionalProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
public class OrangeUserWebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrangeUserWebApplication.class)
                .listeners(new LoadAdditionalProperties())
                .run(args);
    }
}
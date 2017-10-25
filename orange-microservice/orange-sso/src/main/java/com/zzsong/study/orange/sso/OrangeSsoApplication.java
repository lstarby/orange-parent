package com.zzsong.study.orange.sso;

import com.zzsong.study.orange.sso.configure.LoadAdditionalProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
public class OrangeSsoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrangeSsoApplication.class)
                .listeners(new LoadAdditionalProperties())
                .run(args);
    }


}

package com.zzsong.study.orange.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zzsong on 2017/10/12.
 */
@SpringBootApplication
@EnableEurekaServer
public class OrangeEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeEurekaApplication.class, args);
    }
}

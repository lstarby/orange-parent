package com.zzsong.study.orange.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
public class OrangeUserWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeUserWebApplication.class, args);
	}
}

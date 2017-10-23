package com.zzsong.study.orange.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrangeUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeUserApplication.class, args);
	}
}

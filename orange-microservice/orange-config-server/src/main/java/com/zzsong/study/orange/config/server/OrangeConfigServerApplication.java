package com.zzsong.study.orange.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaServer
public class OrangeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeConfigServerApplication.class, args);
	}
}

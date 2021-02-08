package com.peng.xlogserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class XlogserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(XlogserverApplication.class, args);
	}

}

package com.peng.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.peng.base.controller"})
@SpringBootApplication
public class BaseApplication{

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}

}

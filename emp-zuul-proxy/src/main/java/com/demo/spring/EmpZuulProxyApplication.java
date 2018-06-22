package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EmpZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpZuulProxyApplication.class, args);
	}
	
	
	/*	 
	 *  path: /host/**
	 * http://localhost:9080/api/host/api/emp/get/100
	 *   path: /service/**
	 * http://localhost:9080/api/service/app/emp?id=100
	 *   path: /client/**
	 * http://localhost:9080/api/client/emp/get/200
	 * */
}

package com.microservice.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}


	//Rest template config
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	//webflux
	@Bean
	public WebClient webClient(){
		return  WebClient.builder().build();
	}
}

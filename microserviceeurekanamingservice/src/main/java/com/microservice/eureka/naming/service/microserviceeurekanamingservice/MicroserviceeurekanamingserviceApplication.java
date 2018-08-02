package com.microservice.eureka.naming.service.microserviceeurekanamingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceeurekanamingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceeurekanamingserviceApplication.class, args);
	}
}

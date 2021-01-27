package com.github.linealnan.lutebackend.eureka.com.github.linealnan.lutebackend.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LuteBackendEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuteBackendEurekaApplication.class, args);
	}

}

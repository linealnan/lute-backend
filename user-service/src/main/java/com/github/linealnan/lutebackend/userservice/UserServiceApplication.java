package com.github.linealnan.lutebackend.userservice;

import com.github.linealnan.lutebackend.userservice.repository.UserRepository;
import com.github.linealnan.lutebackend.userservice.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// This code creates a Flux of four sample Persons objects, saves them to the DB. Then, queries all the Persons from the DB and print them to the console.
	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll()
					.thenMany(Flux.just(new User("1", "linealnan@gmail.com"))
					.flatMap(userRepository::save))
					.thenMany(userRepository.findAll())
					.subscribe(System.out::println);

		};
	}

}

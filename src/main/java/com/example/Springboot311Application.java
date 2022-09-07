package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class Springboot311Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot311Application.class, args);
	}

}

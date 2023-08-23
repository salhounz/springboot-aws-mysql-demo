package com.codysullins.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAwsDemoApplication {

	public static void main(String[] args) {
		System.out.println("This is in dev");
		SpringApplication.run(SpringbootAwsDemoApplication.class, args);
	}

}

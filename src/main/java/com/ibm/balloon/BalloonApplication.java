package com.ibm.balloon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BalloonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalloonApplication.class, args);
	}

}

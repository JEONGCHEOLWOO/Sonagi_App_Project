package com.sona.gi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiApplication.class, args);
	}

}

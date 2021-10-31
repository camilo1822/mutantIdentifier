package com.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantsMain {

	public static void main(String[] args) {
		System.out.println("la principal");
		SpringApplication.run(Service.class, args);

	}

}

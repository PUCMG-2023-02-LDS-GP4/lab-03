package com.unibank.sistemabancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SistemaBancarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaBancarioApplication.class, args);
	}
	
}

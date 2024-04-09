package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.curso.controller", "com.curso.service", "com.curso.inicio" })
public class EjercicioCursoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCursoSpringApplication.class, args);
	}

}

package com.curso.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication(scanBasePackages = { "com.curso.controller", "com.curso.service" })
public class EjercicioCursoSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCursoSpring2Application.class, args);
	}

	@Bean
	public RestClient getRestClient() {
		return RestClient.create();
	}

}

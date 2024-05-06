package com.curso.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication(scanBasePackages = { "com.curso.controller", "com.curso.service" })
public class EjercicioCursoSpring5MicroservicioFormacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCursoSpring5MicroservicioFormacionApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestClient.Builder restClient() {
	    return RestClient.builder();
	}

}

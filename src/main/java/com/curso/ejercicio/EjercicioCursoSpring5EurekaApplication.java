package com.curso.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EjercicioCursoSpring5EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCursoSpring5EurekaApplication.class, args);
	}

}

package com.example.academia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AcademiaApplication {

	public static void main(String[] args) {
		// Esta linha inicia o servidor embutido (Tomcat) e o banco H2
		SpringApplication.run(AcademiaApplication.class, args);

		System.out.println("=== Sistema Online ===");
		System.out.println("Acesse o Swagger em: http://localhost:8080/swagger-ui.html");
	}
}
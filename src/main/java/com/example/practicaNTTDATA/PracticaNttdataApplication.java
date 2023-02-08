package com.example.practicaNTTDATA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User API", version = "2.0", description = "User API"))
public class PracticaNttdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaNttdataApplication.class, args);	
		}
}
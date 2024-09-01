package com.example.BackendCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BackendCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCrudApplication.class, args);
	}

}

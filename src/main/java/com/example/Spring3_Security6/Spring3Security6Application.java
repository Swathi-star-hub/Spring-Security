package com.example.Spring3_Security6;

import com.example.Spring3_Security6.dto.Product;
import com.example.Spring3_Security6.repo.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class Spring3Security6Application {

	@Autowired
	private UserInfoRepository repo;

	@PostConstruct
	public void initUsers() {
		List<Product> products = Stream.of(
				new Product(101, "javatechie", 1, 3000.00),
				new Product(102, "user1", 3, 2000.00),
				new Product(103, "user2", 4, 3700.00)
		).collect(Collectors.toList());
		//repo.saveAll(products);

	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Spring3Security6Application.class, args);
		System.out.println(context.getApplicationName());
	}

}

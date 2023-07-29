package com.example.coffeehouse;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CoffeeHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeHouseApplication.class, args);
	}

}

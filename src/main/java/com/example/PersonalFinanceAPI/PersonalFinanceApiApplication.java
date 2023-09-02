package com.example.PersonalFinanceAPI;

import com.example.PersonalFinanceAPI.domain.services.ExpenseService;
import com.example.PersonalFinanceAPI.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.PersonalFinanceAPI.domain.repositories")
public class PersonalFinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApiApplication.class, args);
	}

	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private UserService userService;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*");
			}
		};
	}
}

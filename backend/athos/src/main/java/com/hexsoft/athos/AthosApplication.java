package com.hexsoft.athos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AthosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthosApplication.class, args);
	}

	// Enable CORS globally
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/panel/*").allowedOrigins("http://192.168.0.102:8080");
				registry.addMapping("/**");
			}
		};
	}
}

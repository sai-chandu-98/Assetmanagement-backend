package com.assetmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AssetmanagementsystemprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetmanagementsystemprojectApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**").
	            allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .maxAge(3600L);;
			}
		};
	}

}

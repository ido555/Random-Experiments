package com.example.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WebConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() // show info on what methods 
				.apis(RequestHandlerSelectors.any()) // filter by package / classes / methods
				.paths(PathSelectors.any()) // and filter by Path - only /Cars or only whoever contains abc
				.build();
	
	}
}

package com.configuration.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(
				new Info().title("BlueBerry-ETL").description("Simple and interactive ETL engine by BlueBerry Labs."));
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

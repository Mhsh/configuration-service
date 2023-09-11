package com.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class for the Configuration Application. This class is the entry point
 * for the Spring Boot application. It enables auto-configuration, scans for JPA
 * entities and repositories, and starts the Spring application context.
 */
@SpringBootApplication
@EntityScan("com.storage")
@EnableJpaRepositories(basePackages = { "com.storage" })
public class ConfigurationApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args The command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}
}

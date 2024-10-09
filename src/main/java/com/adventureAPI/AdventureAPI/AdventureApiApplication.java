package com.adventureAPI.AdventureAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AdventureApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdventureApiApplication.class, args);
	}

}

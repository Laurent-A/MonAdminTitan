package com.skateTitan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MonAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonAdminApplication.class, args);
	}

}

package com.atlassian.platform.u20231b475;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AtlassianApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtlassianApplication.class, args);
	}

}

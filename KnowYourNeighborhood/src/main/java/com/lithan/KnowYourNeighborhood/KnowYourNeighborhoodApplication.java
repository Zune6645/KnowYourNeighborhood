package com.lithan.KnowYourNeighborhood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.lithan")
@EntityScan("com.lithan")
@EnableJpaRepositories("com.lithan")
public class KnowYourNeighborhoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowYourNeighborhoodApplication.class, args);
	}

}



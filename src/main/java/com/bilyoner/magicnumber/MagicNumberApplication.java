package com.bilyoner.magicnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MagicNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicNumberApplication.class, args);
	}
}

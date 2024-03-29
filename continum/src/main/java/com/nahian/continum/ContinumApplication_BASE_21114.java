package com.nahian.continum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContinumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContinumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(ContinumApplication.class);

		logger.debug("Debugging...");
	}
}

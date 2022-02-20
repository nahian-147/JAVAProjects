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
	public void run(String... args) {
		Logger logger = LoggerFactory.getLogger(ContinumApplication.class);

        logger.info("Continuum Application Starting...");
		logger.debug("Debugging...");
		logger.info("This is an Info...");
		logger.warn("This is a Warning...");
		logger.info("From Eclipse");
		
		double s = 0.0;
		for (int k=0;k<5;k++) {
			s += 1/java.lang.Math.pow(3, k);
		}
		logger.info("sum "+s);
		logger.info("Continuum Application Shutting Down");
	}
}

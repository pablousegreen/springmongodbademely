package com.springmongodbademely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringmongodbademelyApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ProcessAlarms.class);
	public static void main(String[] args) {
		LOG.info("we are beginning the app: SpringmongodbademelyApplication ");
		SpringApplication.run(SpringmongodbademelyApplication.class, args);
	}
}

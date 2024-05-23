package com.incident;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IncidentManagementApplication {
	private static final Logger logger = LoggerFactory.getLogger(IncidentManagementApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IncidentManagementApplication.class, args);
		displayActiveProfiles(context);
	}

	private static void displayActiveProfiles(ConfigurableApplicationContext context) {
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		if (activeProfiles.length == 0) {
			logger.info("No active profiles.");
		} else {
			logger.info("Active profiles: {}", String.join(", ", activeProfiles));
		}
	}
}

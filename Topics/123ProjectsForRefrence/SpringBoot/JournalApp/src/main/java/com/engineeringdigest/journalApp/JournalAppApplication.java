package com.engineeringdigest.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.engineeringdigest.journalApp.model.UserMetadataModel;

@SpringBootApplication
public class JournalAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JournalAppApplication.class, args);
		System.out.println("kaun sa env hai " + context.getEnvironment().getActiveProfiles()[0]);
	}

}

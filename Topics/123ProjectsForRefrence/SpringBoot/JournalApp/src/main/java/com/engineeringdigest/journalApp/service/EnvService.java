package com.engineeringdigest.journalApp.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvService {

	private Environment environment;

	public EnvService(Environment environment) {

		this.environment = environment;
	}

	public String getActiveProfile() {

		return String.join(",", environment.getActiveProfiles());
	}

	public String getProperty(String key) {

		return environment.getProperty(key);
	}
}

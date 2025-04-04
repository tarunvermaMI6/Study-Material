package com.engineeringdigest.journalApp;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppCache {

	@PostConstruct
	public void init() {

		// will run it when application start
		System.err.println("use it get some property from database like we were doing in wheebox...");

	}
}

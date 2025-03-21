package com.engineeringdigest.journalApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class SyncForMicroservice {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/get")
	public String getOrder() {

		String rep = restTemplate.getForObject("http://localjhos", String.class);
		return rep;
	}

}

package com.example.paymentservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("data/")
public class SyncAPI {

	@GetMapping("/geTdata")
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("Synchronous Response");
    }
	
	
	
	public void consumeTheAPI() {
		
		RestTemplate restTemp = new RestTemplate();
		restTemp.getForObject("http://localhost:8080/data/getTdata",String.class);
	}
}

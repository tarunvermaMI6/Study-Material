package com.example.paymentservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("getOrderAsync")
public class ASyncForMicroservice {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping("/order")
	public void sendOrder(@RequestBody String data) { // producer

		kafkaTemplate.send("orderTopic", data);
	}
}

// suppose this is another service

@RestController
@RequestMapping
class SericeB{
	
	// listner
	
	@KafkaListener(topics = "orderTopic, groupId=paymentGroup")
	public void listenToTopic(String order) {
		
		
	}
}













package com.engineeringdigest.journalApp.controller;




import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.engineeringdigest.journalApp.entity.User;

@RestController
@RequestMapping("/external")
public class CallExternalAPI {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${external.geturl}")
	private String url;

	@GetMapping("/getCall")
	public ResponseEntity<?> callingAnAPI() {

		System.out.println("callingAnAPI .........");
	//	String url = "http://localhost:8080/user/get?name=tarun"; // internal url only for demo
		ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, null, User.class);
		User user = response.getBody();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/postCall")
	public void callingAnPostAPI() {

		/*  
		JSONObject	 obj = new JSONObject();
		obj.put("userName", "baadshah");
		obj.put("password", "1234");
		obj.put("roles", "Admin");
		HttpEntity<String> httpEntity = new HttpEntity<String>(obj.toString()); */
	
		HttpHeaders headers = new HttpHeaders();
		headers.set("meow", "meow");
		User user = User.builder().userName("baadshah").password("1234").roles("Admin").build();
		HttpEntity<User> httpEntity = new HttpEntity<User>(user,headers);

		System.out.println("callingAnPostAPI .........");
		String url = "http://localhost:8080/user/save"; // internal url only for demo
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println("response==== "+response);
		
	}
}

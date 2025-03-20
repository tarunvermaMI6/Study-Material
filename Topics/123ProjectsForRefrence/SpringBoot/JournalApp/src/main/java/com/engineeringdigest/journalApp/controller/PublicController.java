package com.engineeringdigest.journalApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringdigest.journalApp.entity.User;

@RestController
@RequestMapping("/public")
public class PublicController {

	static Map<Long, User> userMap = new HashMap<>();
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllUser() {

		return new ResponseEntity<>(userMap, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMap.put(user.getId(), user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}

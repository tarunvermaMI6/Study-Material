package com.engineeringdigest.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.JwtUtil;
import com.engineeringdigest.journalApp.service.UserDetailServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	AuthenticationManager authenticationManager;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDetailServiceImpl.saveUser(user);

		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<User> getUser(@RequestParam String name) {

		User user = userDetailServiceImpl.getUserByName(name);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/checkConsumer")
	public ResponseEntity<String> checkConsumer(@RequestParam String name) {

		log.info("getting called checkConsumer");

		return new ResponseEntity<String>("yo", HttpStatus.OK);
	}

	@GetMapping("/get-kafka-test")
	public ResponseEntity<String> getUser(@RequestParam String key, @RequestParam String value) {

		kafkaTemplate.send("food", key, value);

		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

			UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(user.getUserName());
			String jwtToken = jwtUtil.generateToken(userDetails.getUsername());
			return new ResponseEntity<String>(jwtToken,HttpStatus.OK);
		} catch (Exception e) {
			log.error("wrong username and password...."+e);
			return new ResponseEntity<String>("wrong username and password",HttpStatus.BAD_REQUEST);
		}
	}

}

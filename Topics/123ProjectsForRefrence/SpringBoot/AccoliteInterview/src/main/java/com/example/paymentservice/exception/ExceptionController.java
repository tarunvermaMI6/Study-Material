package com.example.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

	public String userId(@PathVariable("id") int id) {

		if (id == 0) {
			throw new IllegalArgumentException("custom illegal");
		}

		return "user";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> throwException(IllegalArgumentException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

}

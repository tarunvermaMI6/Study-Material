package com.engineeringdigest.journalApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.engineeringdigest.journalApp.api.UserNotFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> thorughGlobalException(Exception ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_EXTENDED);
	}

}

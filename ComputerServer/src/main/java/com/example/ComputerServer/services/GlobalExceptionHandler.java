package com.example.ComputerServer.services;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Advice - aspect oriented programming type thing
// will wrap any matching methods and add the exception handling code
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/* ALL PROJECT CONTROLLERS global exception handler */
	// for every single method in every controller this will wrap around it and
	// execute if this exception is thrown
	@ExceptionHandler(InvalidComputerException.class)
	public ResponseEntity<String> handleInvalidComputer() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found :(");
	}

//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> handleNoSuch(){
//		return null;
//	}
}

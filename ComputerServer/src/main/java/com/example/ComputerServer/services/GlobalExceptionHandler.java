package com.example.ComputerServer.services;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Advice - aspect of programming type thing
// will wrap matching methods and add the exception handling code
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

}

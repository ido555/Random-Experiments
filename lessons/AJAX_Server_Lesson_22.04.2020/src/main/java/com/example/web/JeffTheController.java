package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jeff")
public class JeffTheController {
	
	@GetMapping("greetJS")
	public String greetUser() {
		return "Guten tag Vanilla JS";
	}
	@GetMapping("greetJQuery")
	public String greetUser2() {
		return "Guten tag jQuery";
	}
	@PostMapping("greetPOST")
	public String greetUser3() {
		return "Guten tag From Post City!";
	}
}

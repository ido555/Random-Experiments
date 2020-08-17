package com.example.webControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// no error checking of any kind
@RestController
@RequestMapping("calc")
public class Controller1 {
//	Create a new CalcController: add(x,y), mult(x,y), div(x,y) - both use GetMapping
		@GetMapping("add")
		public int add(int a, int b) {
			return a+b;
		};
		@GetMapping("multiply")
		public int multiply(int a, int b) {
			return a*b;
		};
		@GetMapping("divide")
		public int divide(int a, int b) {
			return a/b;
		};
}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.beans.Car;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AngularServer16052020Application {

	public static void main(String[] args) {
		SpringApplication.run(AngularServer16052020Application.class, args);
	}

}

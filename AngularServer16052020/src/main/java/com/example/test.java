package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Car;
import com.example.repos.CarRepo;

public class test {
	@Autowired
	public CarRepo repo;
	ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext();
	Car car = ctx.getBean(Car.class);
}

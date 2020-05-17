package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Entity(name = "cars")
@Transactional
public class Car {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String model, color;
	@Column(nullable = false)
	@Max(value = 2025)
	@Min(value = 1900)
	private int year;
	
	// empty ctor for Hibernate
	public Car() {
	}
	public Car(String model, String color, int year) {
		this.model = model;
		this.color = color;
		this.year = year;
	}
	public long getId() {
		return id;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public int getYear() {
		return year;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setYear(int year) {
		this.year = year;
	}
}

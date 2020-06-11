package com.example.ComputerServer.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="computers")
public class Computer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String model;
	private int ram;
	private double price;
	
	public Computer() {}

	public Computer(String model, int ram, double price) {
		super();
		this.model = model;
		this.ram = ram;
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", model=" + model + ", ram=" + ram + ", price=" + price + "]";
	}
	
	
}

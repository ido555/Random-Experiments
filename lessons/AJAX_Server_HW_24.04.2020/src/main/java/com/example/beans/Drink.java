package com.example.beans;

public class Drink {
	private long id;
	private String name;
	private double alcohol;
	private double price;

	public Drink(long id, String name, double alcohol, double price) {
		this.id = id;
		this.name = name;
		this.alcohol = alcohol;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAlcohol() {
		return alcohol;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

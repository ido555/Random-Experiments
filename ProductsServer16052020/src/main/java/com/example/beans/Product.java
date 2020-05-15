package com.example.beans;

import java.sql.Date;

public class Product {
	private long id;
	private String title;
	private double price;
	private Date expirationDate;

	private static int counter = 1;

	public Product(String title, double price, Date expirationDate) {
		this.id = counter;
		counter++;
		this.title = title;
		this.price = price;
		this.expirationDate = expirationDate;
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}

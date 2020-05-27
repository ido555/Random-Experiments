package com.example.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	private String name;
	private String email;
	private int age;
	private StockDataPoint StockDataPoint;

	@Override
	public String toString() {
		return "Test [name=" + name + ", email=" + email + ", age=" + age + ", phones=" + StockDataPoint.getPhones() + "]";
	}

}

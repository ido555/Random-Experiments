package oop_Big_Targil_Preperation_for_Matala;

import java.util.ArrayList;

public class Car {
	private String model;
	private int year;
	private ArrayList<Driver> drivers = new ArrayList<Driver>();

	public Car(String model, int year, ArrayList<Driver> drivers) {
		this.model = model;
		this.year = year;
		this.drivers = drivers;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	public void addDrivers(Driver driver) {
		if (!(drivers.size() > 2)) {
			drivers.add(driver);
		}
	}

	public void setYear(int year) {
		if (year > 1959 && year < 2020) // 1960 - 2019
			this.year = year;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", drivers=" + drivers + "]\n\n";
	}
}

package oop_Big_Targil_Preperation_for_Matala;

import java.util.ArrayList;

public class Circuit {
	private String name;
	private String country;
	private int length;
	private ArrayList<Car> cars = new ArrayList<Car>();

	public Circuit(String name, String country, int length, ArrayList<Car> cars) {
		this.name = name;
		this.country = country;
		setLength(length); // 
		this.cars = cars;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getLength() {
		return length;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	private void setLength(int length) {
		if (length > 3 && length < 31) { // 4 - 30
			this.length = length;
		}
	}
	public void addCar(Car car) {
		this.cars.add(car);
	}

	@Override
	public String toString() {
		return "Circuit [name=" + name + ", country=" + country + ", length=" + length + ", cars=" + cars + "]\n";
	}

}

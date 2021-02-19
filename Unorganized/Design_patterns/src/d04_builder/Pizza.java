package d04_builder;

import java.util.ArrayList;

public class Pizza {
	private int diameter;
	private int numOfSlices;
	private ArrayList<String> toppings;
	private double price;

	public Pizza() {}
	
	public Pizza(int diameter, ArrayList<String> toppings) {
		super();
		this.diameter = diameter;
		this.toppings = toppings;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getNumOfSlices() {
		return numOfSlices;
	}

	public void setNumOfSlices(int numOfSlices) {
		this.numOfSlices = numOfSlices;
	}

	public ArrayList<String> getToppings() {
		return toppings;
	}

	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}

	public double getPrice() {
		return price;
	}

	
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pizza [diameter=" + diameter + ", numOfSlices=" + numOfSlices + ", toppings=" + toppings + ", price="
				+ price + "]";
	}

	
	
}

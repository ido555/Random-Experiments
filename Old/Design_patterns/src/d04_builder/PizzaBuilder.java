package d04_builder;

import java.util.ArrayList;

public class PizzaBuilder {

	private Pizza pizza = new Pizza();
//	private int diameter;
//	private int numOfSlices;
//	private ArrayList<String> toppings = new ArrayList<String>();
//	private double price;
	
	public PizzaBuilder setDiameter(int diameter) {
//		this.diameter = diameter;
		pizza.setDiameter(diameter);
		return this;
	}
	
	public PizzaBuilder addTopping(String topping) {
//		toppings.add(topping);
		pizza.getToppings().add(topping);
		return this;
	}
	
	public Pizza build() {
//		this.numOfSlices = diameter / 10;
//		this.price = 20 + diameter * 2 + 9 * toppings.size();
//		Pizza pizza =  new Pizza(diameter, toppings);
//		pizza.setPrice(price);
//		pizza.setNumOfSlices(numOfSlices);
		
		pizza.setNumOfSlices(pizza.getDiameter()/10);
		pizza.setPrice(20 + pizza.getDiameter() * 2 + 9 * pizza.getToppings().size());
		return pizza;
	}
	
	
	
}

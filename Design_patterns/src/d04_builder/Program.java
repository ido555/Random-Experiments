package d04_builder;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		Pizza pizza1 = new PizzaBuilder().setDiameter(10).addTopping("Extra cheese").addTopping("Shrooms").build();
		
		Pizza pizza2 = new PizzaBuilder().setDiameter(5).addTopping("Black Olives").setDiameter(100).build();
		
		Pizza pizza3 = new PizzaBuilder().addTopping("Pineapple").setDiameter(30).build();
		
		System.out.println(pizza1);
		System.out.println(pizza2);
		System.out.println(pizza3);
		
		ArrayList<String> toppings = new ArrayList<String>();
		toppings.add("Shrooms");
		toppings.add("Olives");
		Pizza pizza4 = new Pizza(10, toppings);
		
		
	}
	

}

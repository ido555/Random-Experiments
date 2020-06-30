package reflection1_annotation1;

import java.util.Arrays;

public class Dessert {
	private String name;
	private int calories;
	private double price;
	private String[] ingredients;
	public int stam;
	protected long stam2;

	public Dessert(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	public Dessert(String name, int calories, double price, String[] ingredients) {
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	@annotation1(value = "Calories in Joules", isRunnable = false)
	public int getCalories() {
		return calories;
	}
	@annotation1(value = "Price in USD", isRunnable = true)
	public double getPrice() {
		return price;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dessert [name=" + name + ", calories=" + calories + ", price=" + price + ", ingredients="
				+ Arrays.toString(ingredients) + "]";
	}
}

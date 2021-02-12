package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Phone {
	private double price;
	private String model;
	private String color;
	private String manufactorer;
	@Autowired
	private PhoneStore myStore;
	public Phone() {
	}

	public Phone(int price, String model, String color, String manufactorer) {
		this.price = price;
		this.model = model;
		this.color = color;
		this.manufactorer = manufactorer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufactorer() {
		return manufactorer;
	}

	public void setManufactorer(String manufactorer) {
		this.manufactorer = manufactorer;
	}

	@Override
	public String toString() {
		return "Phone [price=" + price + ", model=" + model + ", color=" + color + ", manufactorer=" + manufactorer
				+ ", myStore=" + myStore + "]";
	}

	
}

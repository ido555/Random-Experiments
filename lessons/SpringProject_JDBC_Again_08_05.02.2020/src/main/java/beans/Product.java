package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Product {
	private int id;
	private double listPrice;
	private String productName;
	private String category;

	public Product(int id, double listPrice, String productName, String category) {
		super();
		this.id = id;
		this.listPrice = listPrice;
		this.productName = productName;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", listPrice=" + listPrice + ", productName=" + productName + ", category="
				+ category + "]";
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

}

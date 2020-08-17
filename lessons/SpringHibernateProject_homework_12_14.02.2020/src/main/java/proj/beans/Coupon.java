package proj.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import proj.enums.CategoryType;

@Entity
@Table(name = "coupons") // default is class name
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment per table
	private int id;
	@ManyToOne
	private Company company;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private double price;
	@Column
	private CategoryType category;

	public Coupon() {
	}

	public Coupon(Company company, String title, String description, double price, CategoryType category) {
		this.company = company;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", category=" + category + "]";
	}

	public int getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

}

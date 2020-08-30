package proj.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private String desc;
	@Column
	private double price;
	@ManyToOne
	private Company company;
	public Coupon() {
	}
	public Coupon(String title, String desc, double price, Company company) {
		this.title = title;
		this.desc = desc;
		this.price = price;
		this.company = company;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", desc=" + desc + ", price=" + price + ", company=" + company
				+ "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getId() {
		return id;
	}
	
}

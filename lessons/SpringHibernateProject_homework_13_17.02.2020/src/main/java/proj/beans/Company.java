package proj.beans;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import proj.enums.CategoryType;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@OneToMany(mappedBy = "company") // mapped by the Company variable name in Coupon
	private List<Coupon> coupons;
	@Column
//	@Enumerated(EnumType.STRING)
	private CategoryType category; // Hibernate handles enums by itself
	public Company() {
	}
	public Company(String name, String email, String password, List<Coupon> coupons, CategoryType category) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.coupons = coupons;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", coupons="
				+ coupons + ", category=" + category + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	public CategoryType getCategory() {
		return category;
	}
	public void setCategory(CategoryType category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	
}

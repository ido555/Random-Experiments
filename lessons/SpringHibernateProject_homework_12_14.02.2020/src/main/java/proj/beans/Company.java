package proj.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies") // default is class name
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment per table
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	// Eager fetching loads all tables with a relationship to Company. kinda like JOIN ON companies.company_id = coupons.company_id
	// and it does that automagically ..... the default is Lazy because its the most efficient
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<Coupon> coupons;

	public Company() {
	}

	public Company(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "] coupons=";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

}

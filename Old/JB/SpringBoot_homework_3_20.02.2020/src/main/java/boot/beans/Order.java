package boot.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column
	private Date date;
	@Column
	private String address;
	@ManyToOne
	private Employee employee;
	@ManyToMany
	@JoinTable(name = "order_products" ,
	joinColumns = @JoinColumn(name = "order_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products; // can have many of the same product in one order
	// therefore a List is used and not a Set 

	public Order() {
	}

	public Order(Date date, String address, Employee employee) {
		this.date = date;
		this.address = address;
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", address=" + address + ", products=" + products + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public Date getDate() {
		return date;
	}
	public String getAddress() {
		return address;
	}
	public Employee getEmployee() {
		return employee;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}

package boot.facades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.DBDAOs.EmployeeDBDAO;
import boot.DBDAOs.OrderDBDAO;
import boot.DBDAOs.ProductDBDAO;
import boot.beans.Employee;
import boot.beans.Order;
import boot.beans.Product;

@Service
public class CustomerFacade {
	@Autowired
	private EmployeeDBDAO empDBDAO;
	@Autowired
	ProductDBDAO prodDBDAO;
	@Autowired
	OrderDBDAO ordDBDAO;

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		products.addAll(prodDBDAO.findAll());
		return products;
	}

	public Product getProductByName(String name) {
		Product prod = prodDBDAO.findProductByName(name);
		if (prod != null) {
			return prod;
		}
		System.out.println("no such product. returning null");
		return prod;
	}

	public Employee getEmployeeByEmail(String email) {
		Employee emp = empDBDAO.findEmployeeByEmail(email);
		if (emp != null) {
			return emp;
		}
		System.out.println("no such employee. returning null");
		return emp;
	}
	
	public void placeOrder(Order order, List<Product> products) {
		order.setProducts(products);
		ordDBDAO.save(order);
	}
}

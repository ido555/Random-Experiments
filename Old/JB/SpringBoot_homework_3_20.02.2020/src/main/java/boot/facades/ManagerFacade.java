package boot.facades;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.DBDAOs.EmployeeDBDAO;
import boot.DBDAOs.OrderDBDAO;
import boot.DBDAOs.ProductDBDAO;
import boot.beans.Employee;
import boot.beans.Product;

@Service
public class ManagerFacade {
	@Autowired
	private EmployeeDBDAO empDBDAO;
	@Autowired
	private ProductDBDAO prodDBDAO;

	public void addEmployee(Employee employee) {
		if (empDBDAO.findEmployeeByEmail(employee.getEmail()) == null) {
			empDBDAO.save(employee);
		} else {
			System.out.println("duplicate email. employee not added");
		}
	}

	public void addProduct(Product product) {
		if (prodDBDAO.findProductByName(product.getName()) == null) {
			prodDBDAO.save(product);
		} else {
			System.out.println("duplicate name. product not added");
		}
	}

	public void updateEmployee(Employee employee) {
		// add id and email change(duplicate email) checks
		empDBDAO.save(employee);
	}

	public void updateProduct(Product product) {
		// add checks
		prodDBDAO.save(product);
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.addAll(empDBDAO.findAll());
		return employees;
	}

	public Employee getEmployeeById(int id) {
		Employee emp = empDBDAO.findById(id).orElse(null);
		if (emp != null) {
			return emp;
		}
		System.out.println("no such employee. returning null");
		return emp;
	}
}

package boot.DBDAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.beans.Employee;
import boot.beans.Product;

public interface EmployeeDBDAO extends JpaRepository<Employee, Integer>{

	Employee findEmployeeByEmail(String email);
	
}

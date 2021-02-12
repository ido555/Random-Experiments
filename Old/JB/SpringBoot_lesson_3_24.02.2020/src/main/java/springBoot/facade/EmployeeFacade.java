package springBoot.facade;

import org.springframework.stereotype.Service;

import springBoot.beans.Employee;

@Service
public class EmployeeFacade {
	
	public Employee createEmployee(long id, String name) {
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		return emp;
	}
	
	public String deleteEmployee(long id) {
		return "Employee" + id + " was deleted";
	}
	
}

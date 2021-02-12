package test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import test.beans.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
}

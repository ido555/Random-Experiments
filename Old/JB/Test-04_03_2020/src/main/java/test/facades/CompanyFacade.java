package test.facades;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import test.beans.Employee;
import test.beans.Job;
import test.exceptions.NoMatchingName;
import test.exceptions.NoSuchId;
import test.repositories.EmployeeRepo;
import test.repositories.JobRepo;

@Service()
@Scope("singleton")
public class CompanyFacade {
	@Autowired
	JobRepo jobRepo;
	@Autowired
	EmployeeRepo empRepo;

	public void addEmployee(Employee newEmployee) {
		empRepo.save(newEmployee);
	}

	public Employee getEmployeeById(Long employeeId) throws NoSuchId {
		return empRepo.findById(employeeId).orElseThrow(NoSuchId::new);
	}

	public List<Employee> getEmployeesByName(String name) throws NoMatchingName {
		List<Employee> employees = empRepo.findByName(name);
		if (employees.isEmpty()) {
			throw new NoMatchingName();
		}
		return employees;
	}

	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	public List<Job> getJobsByEndDate(Date endDate) {
		return jobRepo.findByEndDate(endDate);
	}

	public List<Job> getJobsBetweenEndDates(Date minEndDate, Date maxEndDate) {
		return jobRepo.findByEndDateBetween(minEndDate, maxEndDate);
	}
}

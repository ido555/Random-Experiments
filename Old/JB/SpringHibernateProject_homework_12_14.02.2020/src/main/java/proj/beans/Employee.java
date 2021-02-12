package proj.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private double salary;
	@Column
	private int yearsAtWork;
	@OneToMany
	private Company company;

	public Employee() {
	}

	public Employee(String name, double salary, int yearsAtWork, Company company) {
		this.name = name;
		this.salary = salary;
		this.yearsAtWork = yearsAtWork;
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", yearsAtWork=" + yearsAtWork
				+ ", company=" + company + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getYearsAtWork() {
		return yearsAtWork;
	}

	public Company getCompany() {
		return company;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setYearsAtWork(int yearsAtWork) {
		this.yearsAtWork = yearsAtWork;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}

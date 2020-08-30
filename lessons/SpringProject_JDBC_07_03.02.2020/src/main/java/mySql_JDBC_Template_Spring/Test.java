package mySql_JDBC_Template_Spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			Employee emp = new Employee(10, "first1", "last1");
			EmployeeDBDAO empDB = ctx.getBean(EmployeeDBDAO.class);
			empDB.addEmployee(emp);
		}
	}
}

package mySql_JDBC_Template_Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDBDAO {
	
	@Autowired // does ctx.getbean
	private JdbcTemplate jt;
	
	
	public void addEmployee(Employee employee) {
		jt.update("insert into employees(id, first_name, last_name) values(?,?,?)",
				employee.getId(), employee.getFirstName(), employee.getLastName());
	}
}

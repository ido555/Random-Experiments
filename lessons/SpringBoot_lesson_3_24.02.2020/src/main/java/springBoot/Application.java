package springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springBoot.beans.Employee;
import springBoot.facade.EmployeeFacade;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeFacade empFacade = ctx.getBean(EmployeeFacade.class);
		Employee employee = empFacade.createEmployee(1, "moshe");
		System.out.println(employee);

	}
// AOP aspect oriented programming
// Spring uses AspectJ - AOP framework
// lombok
// Advice - what i want the code to do
// Join point - where i want the code to execute
// Timing when i want the Advice to run
// Join point - AspectJ interface
}

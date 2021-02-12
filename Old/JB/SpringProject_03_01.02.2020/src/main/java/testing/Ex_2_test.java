package testing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex_2.CEO;
import ex_2.Employee;

public class Ex_2_test {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)) {
			CEO ceo = ctx.getBean(CEO.class);
			System.out.println(ceo);
			Employee emp1 = ctx.getBean(Employee.class, "employee1", 4223, "construction", 4, ceo);
			Employee emp2 = ctx.getBean(Employee.class, "employee1", 9321, "electrician", 15, ceo);
			Employee emp3 = ctx.getBean(Employee.class, "employee1", 8213, "construction", 22, ceo);
			System.out.println(emp1);
			System.out.println(emp2);
			System.out.println(emp3);
		}
	}
}

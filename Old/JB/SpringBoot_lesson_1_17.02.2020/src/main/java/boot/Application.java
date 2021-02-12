package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import boot.DBDAOs.PersonDBDAO;
import boot.beans.Person;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		PersonDBDAO personDBDAO = ctx.getBean(PersonDBDAO.class);
		personDBDAO.save(new Person("jeffery", 15));
		for (Person p : personDBDAO.findAll()) {
			System.out.println(p);
		}
		Person p1 = personDBDAO.findById(23).orElse(null);
		if (p1 != null) {
			System.out.println(p1);
		} else {
			System.out.println("no person found");
		}
	}
}

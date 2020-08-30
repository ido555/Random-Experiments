package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import test.beans.Employee;
import test.beans.Job;
import test.exceptions.NoMatchingName;
import test.exceptions.NoSuchId;
import test.facades.CompanyFacade;

@SpringBootApplication
public class Program {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Program.class, args);
		CompanyFacade company = ctx.getBean(CompanyFacade.class);

		List<Job> jobs1 = new ArrayList<Job>();
		Calendar calDate = Calendar.getInstance();
		calDate.set(2021, Calendar.MARCH, 15);
		jobs1.add(new Job("Milk the cows", new Date(calDate.getTimeInMillis())));
		calDate.set(2021, Calendar.APRIL, 1);
		jobs1.add(new Job("Execute elaborate prank", new Date(calDate.getTimeInMillis())));

		List<Job> jobs2 = new ArrayList<Job>();
		calDate.set(2035, Calendar.JANUARY, 11);
		jobs2.add(new Job("Finish Part 2 of Spring Project", new Date(calDate.getTimeInMillis())));
		calDate.set(2020, Calendar.OCTOBER, 31);
		jobs2.add(new Job("Celebrate birthday", new Date(calDate.getTimeInMillis())));

		company.addEmployee(new Employee("Joe", 50000.2, jobs1));
		company.addEmployee(new Employee("Gustafsson", 500.9, jobs2));

		calDate.set(2021, Calendar.APRIL, 1);
		Calendar calDate2 = Calendar.getInstance();
		calDate2.set(2050, Calendar.FEBRUARY, 22);
		try {
			System.out.println("Employee with id 1:");
			System.out.println(company.getEmployeeById(1L));
			
			System.out.println("\nAll employees:");
			System.out.println(company.getAllEmployees());
			
			System.out.println("\n employees named Gustafsson:");
			System.out.println(company.getEmployeesByName("Gustafsson"));
			
			System.out.println("\n all jobs:");
			System.out.println(company.getAllJobs());

			System.out.println("\n getJobsByEndDate:");
			System.out.println(company.getJobsByEndDate(new Date(calDate.getTimeInMillis())));
			
			System.out.println("\n getJobsBetweenEndDates:");
			System.out.println(company.getJobsBetweenEndDates(new Date(calDate.getTimeInMillis()),new Date(calDate2.getTimeInMillis())));
			
		} catch (NoSuchId | NoMatchingName e) {
			e.printStackTrace();
		}
	}

}

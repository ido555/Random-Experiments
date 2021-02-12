package testing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex_1.Car;
import ex_1.Driver;

public class Ex_1_test {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)){
			Driver driver = ctx.getBean(Driver.class);  // does all the get instance(singleton) stuff. i think
			System.out.println(driver);
			driver.setName("Graham");
			driver.setAge(50);
			driver.setNumberOfMedals(300);
			System.out.println(driver);
			driver.setAge(51);
			System.out.println(driver);
			
			Car car1 = ctx.getBean(Car.class , "Ferrari" , 2015, driver);
			System.out.println(car1);
			Car car2 = ctx.getBean(Car.class , "Mclaren" , 2019, driver);
			System.out.println(car2);
			Car car3 = ctx.getBean(Car.class , "Audi" , 1990, driver);
			System.out.println(car3);
			System.out.println("=============================================================");
			car1.setModel("test");
			car2.setModel("test2");
			car3.setModel("test3");
			System.out.println(car1);
			System.out.println(car2);
			System.out.println(car3);
			
			
		}
	}
}

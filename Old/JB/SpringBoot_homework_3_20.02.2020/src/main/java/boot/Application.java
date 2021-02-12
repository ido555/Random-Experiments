package boot;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import boot.beans.Employee;
import boot.beans.Order;
import boot.beans.Product;
import boot.facades.CustomerFacade;
import boot.facades.ManagerFacade;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		ManagerFacade mngFacade = ctx.getBean(ManagerFacade.class);
		CustomerFacade custFacade = ctx.getBean(CustomerFacade.class);
		
//		mngFacade.addEmployee(new Employee("firstName1", "lastName1", "email"));
//		mngFacade.addEmployee(new Employee("firstName2", "lastName2", "email"));
		
//		mngFacade.addProduct(new Product("tennis ball", 15, 100));
//		mngFacade.addProduct(new Product("bike", 25, 200));
		Date now = new Date(Calendar.getInstance().getTimeInMillis());
		Product prod1 = custFacade.getProductByName("tennis ball");
		Product prod2 = custFacade.getProductByName("bike");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(prod1);
		products.add(prod1);
		products.add(prod1);
		products.add(prod2);
		custFacade.placeOrder(new Order(now, "123123123 street", mngFacade.getEmployeeById(1)), products);
	}

}

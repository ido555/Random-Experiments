package garage.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import garage.SpringConfig;
import garage.DBDAOs.CarDBDAO;
import garage.beans.Car;

public class Test {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			CarDBDAO carDBDAO = ctx.getBean(CarDBDAO.class);
			System.out.println(carDBDAO.getAllCars());
			System.out.println(carDBDAO.getCar(1));
			Car car = carDBDAO.getCar(1);
			car.setColor("newAgain");
			car.setYear(5);
//			carDBDAO.updateCar(car);
//			carDBDAO.addCar(car);
		}

	}

}

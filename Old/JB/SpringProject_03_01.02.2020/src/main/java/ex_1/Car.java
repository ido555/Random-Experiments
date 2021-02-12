package ex_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {
	private String model;
	private int year;
	@Autowired
	private Driver driver;

	public Car(String model, int year, Driver driver) {
		this.model = model;
		this.year = year;
		this.driver = driver;
	}

	@Override
	public String toString() {
		return String.format("Car [model=%s, year=%s, driver=%s]", model, year, driver);
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}

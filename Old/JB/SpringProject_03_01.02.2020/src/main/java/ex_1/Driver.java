package ex_1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")

public class Driver {
	private String name = "jeff";
	private int age = 1;
	private int numberOfMedals = 3;

	public Driver() {
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", age=" + age + ", numberOfMedals=" + numberOfMedals + "]";
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getNumberOfMedals() {
		return numberOfMedals;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNumberOfMedals(int numberOfMedals) {
		this.numberOfMedals = numberOfMedals;
	}

}

package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component mark this class for Spring - it can now manage it
@Component
@Scope("prototype") // default is a singleton // prototype is many
public class Pet {
	private String name;
	private String type;
	private int age;
	@Autowired // --> use Dependency injection to make Spring give us the Vet
	private Vet myVet;
	public Pet() {

	}

	public Pet(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + ", myVet=" + myVet + "]";
	}

}

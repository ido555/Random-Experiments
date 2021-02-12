package beans;

public class Pet {
	private String name;
	private String type;
	private int age;
	private Vet myVet;
	
	public Pet(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + ", myVet=" + myVet + "]";
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
	public Vet getMyVet() {
		return myVet;
	}
	public void setMyVet(Vet myVet) {
		this.myVet = myVet;
	}
	
}


public class Dog {
	private int age;
	private String name;

	public Dog(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// special finalizer method
	// runs right before garbage collection
	// good for logs
	public void finalize() {
		System.out.println(name + " is being collected by GC");
	}
}

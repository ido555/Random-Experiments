
public class Teacher extends Person {
	private String profession;

	public Teacher(String name, int age, String profession) {
		super(name, age);
		this.profession = profession;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return super.toString() + "Teacher [profession=" + profession + "]";
	}

}

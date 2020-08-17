package _JDBC_mySQL_College_2;

public class SQL_Student {
	private int id;
	private int grade;
	private int courseNumber;
	private String firstName;
	private String lastName;
	private String email;
	
	public SQL_Student(int id,int grade, int courseNumber, String firstName, String lastName, String email) { // DB reader
		this.id = id;
		this.grade = grade;
		this.courseNumber = courseNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public SQL_Student(int grade, int courseNumber, String firstName, String lastName, String email) { // DB writer?
		this.grade = grade;
		this.courseNumber = courseNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "SQL_Student [id=" + id + ", grade=" + grade + ", courseNumber=" + courseNumber + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	
}

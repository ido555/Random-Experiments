package exceptions;

import exceptions.InvalidAgeException;

public class Student {
	private String name;
	private int age;
	private int grade;

	public Student(String name, int age) throws InvalidAgeException { // = idk how to handle this not my problem
		super();
		this.name = name;
		setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int invalidGrade) throws InvalidGradeException {
		if (invalidGrade >= 0 && invalidGrade <= 100) {
			this.grade = invalidGrade;
		} else {
			// not good this is an exception
			throw new InvalidGradeException(invalidGrade);
		}
	}

	public void setAge(int age) throws InvalidAgeException {
		if (age >= 18 && age <= 70) {
			this.age = age;
		} else {
			throw new InvalidAgeException(); // forces programmer to handle the exception

			// throw new RuntimeException("invalid age"); // no need to add throws and do
			// try catch
			// but shouldn't use to force programmer to handle the problem before it arises
		}

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}

}

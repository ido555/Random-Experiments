package exceptions;

public class Test_Student {

	public static void main(String[] args) {

		try {
			Student s1 = new Student("paa", 19);
			System.out.println(s1);
			// s1.setAge(1522);
			System.out.println(s1);
			s1.setGrade(55);
			System.out.println(s1);
			s1.setGrade(555);
		} catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
			// System.out.println(InvalidAgeException.getSerialversionuid() + ": UID");
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage() + ". offending grade: " + e.getGrade());

		}
	}
}

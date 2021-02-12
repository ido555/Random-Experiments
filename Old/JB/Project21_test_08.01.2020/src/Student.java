import java.util.ArrayList;

public class Student extends Person {
	private ArrayList<Grade> grades;

	public Student(String name, int age, ArrayList<Grade> grades) {
		super(name, age);
		this.grades = grades;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return super.toString() + "Student [getGrades()=" + getGrades();
	}

	public int getStudentAvg() {
		int sum = 0;
		int numOfGrades = this.getGrades().size();
		for (Grade grade : grades) {
			sum += grade.getScore();
		}
		return sum/numOfGrades;
	}
}

import java.util.ArrayList;

public class Classroom {
	private String className;
	private Teacher teacher;
	private ArrayList<Student> students;

	public Classroom(String name, Teacher teacher, ArrayList<Student> students) {
		this.className = name;
		this.teacher = teacher;
		this.students = students;
	}

	public String getName() {
		return className;
	}

	public void setName(String name) {
		this.className = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classroom [className=" + className + ", teacher=" + teacher + ", gradeAvg=" + getGradeAvg()
				+ ", students=" + students + "]";
	}
	
	public int getGradeAvg() {
		int numOfStudents = this.getStudents().size(), avgSum = 0;
		for (Student student : students) {
			avgSum += student.getStudentAvg();
		}
		return avgSum/numOfStudents;
	}
}

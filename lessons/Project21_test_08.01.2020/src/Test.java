import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Grade> grades = new ArrayList<Grade>();
		grades.add(new Grade("prof1", 66));
		grades.add(new Grade("prof2", 50));
		grades.add(new Grade("prof3", 77));
		grades.add(new Grade("prof4", 90));
		grades.add(new Grade("prof5", 88));
		grades.add(new Grade("prof6", 64));
		Student stud = new Student("jeff", 60, grades);
		ArrayList<Student> students = new ArrayList<Student>();
		System.out.println(stud);
		students.add(stud);
		Teacher teacher = new Teacher("jeff", 55, "Math");
		Classroom classroom = new Classroom("class1", teacher, students);
		System.out.println(classroom);
	}

}

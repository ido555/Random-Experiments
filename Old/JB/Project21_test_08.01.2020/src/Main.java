import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// used ints instead of doubles because i dont really want to see that much detail about the grade scores or averages
// 15 students per class
// 6 grades per student
// 1 teacher per class
// 5 classrooms per school
public class Main {

	public static void main(String[] args) {
		ArrayList<String> professions = new ArrayList<String>();
		professions.add("Math");
		professions.add("Chemistry");
		professions.add("Geography");
		professions.add("Literature");
		professions.add("Physics");
		professions.add("Sports");
		HashMap<String, Integer> professionAvgs = new HashMap<String, Integer>();
		HashMap<String, Integer> professionGradesAmount = new HashMap<String, Integer>();
		for (String professionName : professions) { // initialize hashmaps with correct keys and values
			professionAvgs.put(professionName, 0);
			professionGradesAmount.put(professionName, 0);
		}

		School school = generateSchool(); // generate school and all that it contains
		int schoolAvg = 0;

		for (Classroom classroom : school.getClassRooms()) {
			System.out.println((classroom.getName()) + ", Class Grade Average: " + (classroom.getGradeAvg()));
			schoolAvg += classroom.getGradeAvg(); // add every class grade average to the school average
			for (Student student : classroom.getStudents()) {
				for (Grade grades : student.getGrades()) {
					for (int i = 0; i < 6; i++) {
						String profession = grades.getProfession();
						int gradeAtIndexSum = 0;
						gradeAtIndexSum += grades.getScore(); // get the grade sum for the current student
						// example:     Geography key      its value             // the current grade score for the Geography  Grade
						professionAvgs.put(profession, professionAvgs.get(profession) + gradeAtIndexSum);
						// example:              Geography key     how many times it was found + this time that it was found again
						professionGradesAmount.put(profession, professionGradesAmount.get(profession) + 1);
					}
				}
			}
		}
		System.out.println("\nSchool average: " + schoolAvg / school.getClassRooms().size()); // school average sum / amount of classrooms
		for (String professionName : professions) {
			int profSumValue = professionAvgs.get(professionName);
			int profGradeAmount = professionGradesAmount.get(professionName);
			professionAvgs.put(professionName, profSumValue / profGradeAmount);

		}
		System.out.println("\nSchool profession averages: " + professionAvgs);
		System.out.println("\nSchool age average (excluding teachers): " + getSchoolAgeAvg(school));
		System.out.println("\nsports / literature teachers");
		printSchoolSportsLiteratureTeachers(school);
		System.out.println("\nmath / physics teachers");
		printSchoolMathPhysicsTeachers(school);
		System.out.println();
		System.out.println("\nsports league students");
		printSchoolSportsLeauge(school);
		System.out.println();
		System.out.println("\nage range students 20 - 30");
		printAgeRange(school, 20, 30);
		System.out.println("\n\n");
		System.out.println("\nage range students 31 - 120");
		printAgeRange(school, 31, 120);

	}
	public static void printSchoolSportsLiteratureTeachers(School school) {
		int count = 0;
		for (Classroom classroom : school.getClassRooms()) {
			Teacher teacher = classroom.getTeacher();
			if (teacher.getProfession().equals("Sports") || teacher.getProfession().equals("Literature")) {
				System.out.println(teacher);
				count++;
			}
		}
		System.out.println("number of teachers teaching sports or literature: " + count);
	}
	
	public static void printAgeRange(School school , int minRange,int maxRange) {
		for (Classroom classroom : school.getClassRooms()) {
			for (Student student : classroom.getStudents()) {
				if (student.getAge() >= minRange && student.getAge() <= maxRange) {
					System.out.println("Student name: " + student.getName() + ", Student age: "
				+ student.getAge() + ", Student grades average:" + student.getStudentAvg());
				}
			}
		}
	}

	public static void printSchoolMathPhysicsTeachers(School school) {
		for (Classroom classroom : school.getClassRooms()) {
			Teacher teacher = classroom.getTeacher();
			if (teacher.getProfession().equals("Math") || teacher.getProfession().equals("Physics")) {
				System.out.println(teacher);
			}
		}
	}

	public static void printSchoolSportsLeauge(School school) {
		ArrayList<Student> sportStudents = new ArrayList<Student>();
		for (Classroom classroom : school.getClassRooms()) {
			for (Student student : classroom.getStudents()) {
				for (Grade grade : student.getGrades()) {
					if (grade.getProfession().equals("Sports")) {
						if (grade.getScore() >= 90) {
							sportStudents.add(student);
							System.out.println("Student name: " + student.getName() + ", Student Age: "
									+ student.getAge() + ", highest Sports grade: " + grade.getScore());
							break;
						}
					}
				}
			}
		}
	}

	public static int getSchoolAgeAvg(School school) {
		int amountOfStudents = 0;
		int sumOfAges = 0;
		for (Classroom classroom : school.getClassRooms()) {
			for (Student student : classroom.getStudents()) {
				amountOfStudents++;
				sumOfAges += student.getAge();

			}
		}

		return sumOfAges / amountOfStudents;
	}

	public static School generateSchool() {
		return new School(generateClassrooms());
	}

	public static ArrayList<Classroom> generateClassrooms() {
		ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
		for (int i = 0; i < 6; i++) {
			Random rand = new Random();
			String name = "Classroom name " + (rand.nextInt(20) + 1);
			classrooms.add(new Classroom(name, generateTeacher(), generateStudents()));
		}
		return classrooms;
	}

	public static Teacher generateTeacher() {
		ArrayList<String> professions = new ArrayList<String>();
		professions.add("Math");
		professions.add("Chemistry");
		professions.add("Geography");
		professions.add("Literature");
		professions.add("Physics");
		professions.add("Sports");
		Random rand = new Random();
		String name = "name " + (rand.nextInt(20) + 1);
		int age = rand.nextInt(100) + 20;
		String profession = professions.get(rand.nextInt(professions.size()));
		Teacher teacher = new Teacher(name, age, profession);
		return teacher;
	}

	public static ArrayList<Student> generateStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		Random rand = new Random();
		for (int i = 0; i < 15; i++) {
			String name = "name " + (rand.nextInt(20) + 1);
			int age = rand.nextInt(100) + 20;
			students.add(new Student(name, age, generateGrades()));
		}
		return students;
	}

	public static ArrayList<Grade> generateGrades() {
		ArrayList<String> professions = new ArrayList<String>();
		professions.add("Math");
		professions.add("Chemistry");
		professions.add("Geography");
		professions.add("Literature");
		professions.add("Physics");
		professions.add("Sports");
		ArrayList<Grade> grades = new ArrayList<Grade>();
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int score = rand.nextInt(40) + 60;
			String profession = professions.get(rand.nextInt(professions.size()));
			grades.add(new Grade(profession, score));
		}
		return grades;
	}
}

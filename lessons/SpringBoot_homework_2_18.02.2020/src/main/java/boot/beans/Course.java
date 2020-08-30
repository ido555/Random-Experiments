package boot.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	@Column
	private String name;
	@Column
	private int duration;
	@ManyToOne
	private Lecturer lecturer;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Student> students;

	public Course() {
	}

	public Course(String name, int duration, Lecturer lecturer) {
		this.name = name;
		this.duration = duration;
		this.lecturer = lecturer;
	}

	@Override
	public String toString() {
		return "CourseDBDAO [number=" + number + ", name=" + name + ", duration=" + duration + "]";
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

}

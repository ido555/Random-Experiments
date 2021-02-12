package boot.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
//	@OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
	// merge - update/delete
	// persist - insert
	@OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
	private List<Course> courses;

	public Lecturer() {
	}

	public Lecturer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Lecturer [id=" + id + ", name=" + name + ", email=" + email + "], courses=";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}

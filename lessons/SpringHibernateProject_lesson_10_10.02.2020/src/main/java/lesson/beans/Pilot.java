package lesson.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // tell Hibernate to Map this as a Table in SQL
@Table(name = "pilots")
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pilotId;
	@Column
	private String name;
	@Column
	private int experience;
	@Column
	private Date birthdate;
	@Column
	private Double salary;
	@ManyToOne // many pilots to one plane
	private Plane plane;
	public Pilot() { // empty CTOR DONT FORGET
	}

	public Pilot(String name, int experience, Date birthdate, Double salary, Plane plane) {
		this.name = name;
		this.experience = experience;
		this.birthdate = birthdate;
		this.salary = salary;
		this.plane = plane;
	}

	@Override
	public String toString() {
		return "Pilot [pilotId=" + pilotId + ", name=" + name + ", experience=" + experience + ", birthdate="
				+ birthdate + ", salary=" + salary + ", plane=" + plane + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getPilotId() {
		return pilotId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
}

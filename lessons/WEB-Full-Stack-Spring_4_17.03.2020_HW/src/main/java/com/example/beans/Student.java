package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false) // does not ignore Case - aaa@mail.com and aaA@mail.com are different
	private String email;
	@Column
	@Min(0)
	@Max(100)
	private int grade;
	@ManyToOne(fetch = FetchType.EAGER)
	private Course course;

	public Student() {
	}

	public Student(String name, String email, int grade) {
		this.name = name;
		this.email = email;
		this.grade = grade;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getGrade() {
		return grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}

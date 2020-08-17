package com.example.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;
	@Column(nullable = false)
	private String name;
	@Column
	private int duration;
	@Column
	private double price;
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Student> students;
	
	public Course() {
	}
	
	public Course(String name, int duration, double price) {
		this.name = name;
		this.duration = duration;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public double getPrice() {
		return price;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}

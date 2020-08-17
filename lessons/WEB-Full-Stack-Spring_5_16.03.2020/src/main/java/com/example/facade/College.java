package com.example.facade;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Course;
import com.example.beans.Student;
import com.example.db.CoursesRepository;
import com.example.db.StudentsRepository;

@Service
public class College {

	private CoursesRepository courseRepo;
	private StudentsRepository studentRepo;
	
	// we get these two repos by Spring using Dependency Injection
	public College(CoursesRepository courseRepo, StudentsRepository studentRepo) {
		super();
		this.courseRepo = courseRepo;
		this.studentRepo = studentRepo;
	}
	
	public void addStudent(Student student) {
		// try to find by email
		// if not found - add
		// if found - throw OUR exception
		
		
		studentRepo.save(student);
	}
	
	public void addCourse(Course course) {
		courseRepo.save(course);
	}

	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}
	
	public void deleteCourse(long id) {
		// detach students from this course
		Course course = getCourseById(id);
		for (Student student : course.getStudents()) {
			student.setCourse(null);
			studentRepo.save(student);
		}
		// after detaching the students delete the course
		courseRepo.deleteById(id);
	}
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	public Student getStudentById(long id) {
		return studentRepo.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	public Course getCourseById(long id) {
		return courseRepo.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	public Student getStudentByEmail(String email) {
		return studentRepo.findStudentsByEmail(email);
	}
	
	public List<Course> getCoursesByMaxPrice(double maxPrice){
		return courseRepo.findCoursesByPriceLessThan(maxPrice);
	}
	
	public List<Course> getCoursesBetweenDurations(int startDuration, int endDuration){
		return courseRepo.findCoursesByDurationBetween(startDuration, endDuration);
	}
	
}














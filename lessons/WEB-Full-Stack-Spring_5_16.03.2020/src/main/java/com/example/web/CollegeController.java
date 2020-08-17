package com.example.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Course;
import com.example.beans.Student;
import com.example.facade.College;

@RestController
@RequestMapping("college")
public class CollegeController {

	private College college;

	public CollegeController(College college) {
		super();
		this.college = college;
	}
	
	@GetMapping("students")
	public List<Student> getAllStudents(){
		return college.getAllStudents();
	}
	
	@GetMapping("courses")
	public List<Course> getAllCourses(){
		return college.getAllCourses();
	}
	
	@GetMapping("students/{id}")
	public ResponseEntity<?> getStudent(@PathVariable long id){
		try {
			return ResponseEntity.ok( college.getStudentById(id) );
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student found");
		}
	}
	
	@GetMapping("courses/{id}")
	public ResponseEntity<?>  getCourse(@PathVariable long id){
		try {
			return ResponseEntity.ok( college.getCourseById(id) );
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No course found");
		}
	}
	
	@GetMapping("courses/{id}/students")
	public  List<Student> getAllCourseStudents(@PathVariable long id){
		return college.getCourseById(id).getStudents();
	}
	
	@PostMapping("students")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		try {
			college.addStudent(student);
			return ResponseEntity.ok(student);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot add Student with existing email!");
		}
	}
	
	@PostMapping("courses")
	public void addCourse(@RequestBody Course course) {
		college.addCourse(course);
	}
	
	@DeleteMapping("students/{id}") // localhost:8080/college/students/1
	public ResponseEntity<?> deleteStudent(@PathVariable long id) {
		try {
			college.deleteStudent(id);
			return ResponseEntity.noContent().build();
			//return ResponseEntity.ok("Student deleted");
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student with id " + id);
		}
	}
	
	@DeleteMapping("courses/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable long id) {
		try {
			college.deleteCourse(id);
			return ResponseEntity.noContent().build();
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No course with id " + id);
		}
	}
	
}












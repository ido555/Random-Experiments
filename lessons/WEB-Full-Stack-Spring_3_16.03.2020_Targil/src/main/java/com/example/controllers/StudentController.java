package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Student;
import com.example.facades.StudentFacade;

@RestController
@RequestMapping("/students")
public class StudentController {
// get all, get one, update, delete
	@Autowired
	private StudentFacade facade;

	@GetMapping()
	public List<Student> getAllStudents() {
		return facade.getAllStudents();
	}

	@GetMapping("{id}") // localhost:8080/students/6
	public ResponseEntity<?> getStudent(@PathVariable long id) { // ? generic to return any Type
		Student s = facade.getOneStudent(id);
		if (s != null) {
			return ResponseEntity.ok(s);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
	}

	@PostMapping
	public void addStudent(@RequestBody Student student) { // without requestbody localhost:8080?student=asdsdgasgd
		// with requestBody localhost:8080/ and lots of info including Student student
		//  look up wtf this is @RequestBody
		facade.addStudent(student);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		try {
			facade.deleteStudent(id);
			return ResponseEntity.ok("Student deleted");
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
		}
	}

	@PutMapping // put - update request
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		if (facade.updateStudent(student)) {
			return ResponseEntity.ok("Student updated");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error updating student");
	}
}

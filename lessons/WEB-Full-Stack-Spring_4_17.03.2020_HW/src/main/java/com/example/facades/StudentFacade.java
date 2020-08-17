package com.example.facades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.beans.Student;
import com.example.repos.StudentRepo;

@Service
public class StudentFacade {
	@Autowired
	StudentRepo repo;

	public void addStudent(Student student) {
		repo.save(student); // does not ignore email Case - aaa@mail.com and aaA@mail.com are different
	}

	public void deleteStudent(Student student) {
		repo.delete(student);
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Student getStudentById(long id) {
		return repo.findById(id).orElse(null); //  handle null in controller
	}

	public Student getStudentByEmail(String email) { //  handle null in controller
		for (Student student : repo.findAll()) {
			if (student.getEmail().equals(email)) {
				return student;
			}
		}
		return null;
	}

}

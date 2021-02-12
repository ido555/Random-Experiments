package com.example.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Student;
import com.example.repos.StudentRepo;

@Service
public class StudentFacade {
	@Autowired
	private StudentRepo repo; // if user says New StudentFacade Autowired wont work but no compilation error - no
							// good

//	// better for other developers to not get confused and not do ctx.getbean
//	public StudentFacade(StudentsRepo studentsRepo) { // no new repo needed
//		this.repo = studentsRepo;
//	}

	public void addStudent(Student student) {
		repo.save(student);
	}

	public boolean updateStudent(Student student) {
		if (repo.existsById(student.getId())) {
			repo.save(student);
			return true;
		}
		return false;
	}

	public void deleteStudent(long id) {
		repo.deleteById(id);
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Student getOneStudent(long id) {
		return repo.findById(id).orElse(null);
	}
}

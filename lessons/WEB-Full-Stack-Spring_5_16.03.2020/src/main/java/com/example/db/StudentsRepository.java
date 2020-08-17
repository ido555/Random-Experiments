package com.example.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Student;

public interface StudentsRepository extends JpaRepository<Student, Long> {

	Student findStudentsByEmail(String email);
	
}

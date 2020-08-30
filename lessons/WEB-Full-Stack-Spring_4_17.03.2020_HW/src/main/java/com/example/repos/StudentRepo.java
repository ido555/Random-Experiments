package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beans.Student;


public interface StudentRepo extends JpaRepository<Student, Long>{

}

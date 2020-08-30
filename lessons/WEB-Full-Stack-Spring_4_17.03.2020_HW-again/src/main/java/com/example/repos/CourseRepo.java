package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}

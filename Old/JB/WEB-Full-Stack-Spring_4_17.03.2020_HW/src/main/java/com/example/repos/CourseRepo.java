package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beans.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{
	public List<Course> findCoursesByDurationBetween(int minDuration, int maxDuration);
}

package com.example.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {

	// select * from courses where price < maxPrice
	List<Course> findCoursesByPriceLessThan(double maxPrice);
	List<Course> findCoursesByDurationBetween(int minDuration, int maxDuration);
	
}

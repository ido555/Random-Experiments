package com.example.facades;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.beans.Course;
import com.example.repos.CourseRepo;

@Service
public class CourseFacade {
	@Autowired
	CourseRepo repo;

	public boolean addCourse(Course course) {
		for (Course courseCheck : repo.findAll()) {
			if (courseCheck.getName().equals(course.getName())) {
				return false;
			}
		}
		repo.save(course);
		return true;
	}

	public boolean deleteCourse(long id) {
		Course course = repo.findById(id).orElse(null);
		if (course == null) {
			return false;
		}
		course.getStudents().clear();
		repo.save(course); // delete courses_students relationship table
		repo.delete(course); // delete course
		return true;
	}

	public List<Course> getAllCourses() {
		return repo.findAll();
	}

	public Course getCourseById(long id) {
		return repo.findById(id).orElse(null); //  handle null in controller
	}

	// forgot i could do this in the repo
	public List<Course> getCoursesUnderPrice(double maxPrice) {
		List<Course> courses = new ArrayList<Course>();
		for (Course course : repo.findAll()) {
			if (course.getPrice() <= maxPrice) {
				courses.add(course);
			}
		}
		return courses;
	}

	public List<Course> getCoursesBetweenDurations(int minDuration, int maxDuration) {
		return repo.findCoursesByDurationBetween(minDuration, maxDuration);
	}
}

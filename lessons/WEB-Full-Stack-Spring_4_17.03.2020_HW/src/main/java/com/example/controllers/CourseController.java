package com.example.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.beans.Course;
import com.example.facades.CourseFacade;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseFacade facade;

	@PostMapping("/add")
	public ResponseEntity<String> addCourse(@RequestBody Course course) {
		if (facade.addCourse(course)) {
			return ResponseEntity.ok("Course added succesfully");
		}
		return ResponseEntity.ok("Error: course with the same name already exists. course was not added");
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable long id) {
		if (facade.deleteCourse(id)) {
			return ResponseEntity.ok("Course deleted succesfully");
		}
		return ResponseEntity.status(404).body("Error: course not found");
	}

	@GetMapping("/getOne")
	public ResponseEntity<?> getCourseById(long id) {
		Course course = facade.getCourseById(id);
		if (course == null) {
			return ResponseEntity.status(404).body("Error: course not found");
		}
		return ResponseEntity.ok(course);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCourses() {
		List<Course> courses = facade.getAllCourses();
		if (courses.isEmpty()) {
			return ResponseEntity.status(404).body("there are no courses because none were added yet.");
		}
		return ResponseEntity.ok(courses);
	}

	@GetMapping("/getUnderPrice/{maxPrice}")
	public ResponseEntity<?> getCoursesUnderPrice(@PathVariable double maxPrice) {
		List<Course> courses = facade.getCoursesUnderPrice(maxPrice);
		if (courses.isEmpty()) {
			return ResponseEntity.status(404).body("Error: np matching courses not found");
		}
		return ResponseEntity.ok(courses);
	}

	@GetMapping("/getUnderPrice/{minDuration}/{maxDuration}")
	public ResponseEntity<?> getCoursesBetweenDurations(@PathVariable int minDuration, @PathVariable int maxDuration) {
		List<Course> courses = facade.getCoursesBetweenDurations(minDuration, maxDuration);
		if (courses.isEmpty()) {
			return ResponseEntity.status(404).body("Error: no matching courses not found");
		}
		return ResponseEntity.ok(courses);
	}

}

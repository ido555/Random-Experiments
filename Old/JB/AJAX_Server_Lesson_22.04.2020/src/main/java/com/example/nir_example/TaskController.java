package com.example.nir_example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class TaskController {

	private ArrayList<Task> tasks = new ArrayList<Task>();

	@GetMapping
	public List<Task> getAllTasks() {
//		tasks.add(new Task("Task1", new Date()));
//		tasks.add(new Task("Task2", new Date()));
//		tasks.add(new Task("Task3", new Date()));
//		tasks.add(new Task("Task4", new Date()));
		return tasks;
	}

	@GetMapping("one")
	public Task getOneTask() {
		return new Task("WOW", new Date());
	}

	@PostMapping
	public ResponseEntity<String> addTask(@RequestBody Task task) {
		if (task.getTitle().startsWith("task")) { // this is NOT good!
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed! Task cannot start with 'task'");
		} else {
			tasks.add(task);
			return ResponseEntity.ok(task.getTitle() + " added");
		}
	}

}
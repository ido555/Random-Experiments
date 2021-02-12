package com.example.nir_example;

import java.util.Date;

public class Task {

	private String title;
	private Date dueDate;

	public Task(String title, Date dueDate) {
		super();
		this.title = title;
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
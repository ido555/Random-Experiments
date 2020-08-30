package exercise_1_threads_before_test;

import java.util.Calendar;

public class Task {
	private String taskDesc;
	private Calendar dueDate;
	
	public Task(String taskDesc, Calendar dueDate) {
		this.taskDesc = taskDesc;
		this.dueDate = dueDate;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	@Override
	public String toString() {
		return "Task [taskDesc=" + taskDesc + ", dueDate=" + dueDate.getTime() + "]";
	}
	
}

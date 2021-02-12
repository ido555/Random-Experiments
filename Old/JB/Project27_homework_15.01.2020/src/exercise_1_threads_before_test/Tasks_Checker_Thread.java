package exercise_1_threads_before_test;

import java.util.ArrayList;
import java.util.Calendar;

public class Tasks_Checker_Thread extends Thread {
	private ArrayList<Task> tasks;

	public Tasks_Checker_Thread(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public void run() {
		while (true) {
			Calendar now = Calendar.getInstance();
			try {
				for (Task task : tasks) {
					if (now.after(task.getDueDate())) {
						System.out.println("task: " + task.getTaskDesc() + " is its past due date");
					}
				}
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Tasks_Checker_Thread [tasks=" + tasks + "]";
	}

}

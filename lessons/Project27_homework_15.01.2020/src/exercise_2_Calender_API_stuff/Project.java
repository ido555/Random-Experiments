package exercise_2_Calender_API_stuff;

import java.util.Calendar;

public class Project {
	private String name;
	private int numOfTasks;
	private Calendar startDate;
	private Calendar endDate;
	public Project(String name, Calendar startDate, Calendar endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public void addTask(int minutes) {
		// add 1 new task and
		// delay project by minutes (because you added more tasks which take time);
		numOfTasks++;
		endDate.add(Calendar.MINUTE, minutes);
	}
	public String getName() {
		return name;
	}
	public int getNumOfTasks() {
		return numOfTasks;
	}
	public Calendar getStartDate() {
		return startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	@Override
	public String toString() {
		return "Project [name=" + name + ", numOfTasks=" + numOfTasks + ", startDate=" + startDate.getTime() + ", endDate="
				+ endDate.getTime() + "]";
	}
	
	
}

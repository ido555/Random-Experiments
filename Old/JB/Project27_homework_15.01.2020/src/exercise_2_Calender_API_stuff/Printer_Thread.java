package exercise_2_Calender_API_stuff;

import java.util.ArrayList;

public class Printer_Thread extends Thread{
	private ArrayList<Project> projects;
	
	public Printer_Thread(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	
	@Override
	public void run() {
		try {
			sleep(4000);
			for (Project project : projects) {
				System.out.println(project);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package exercise_1_threads_before_test;

import java.util.ArrayList;
import java.util.Calendar;

public class Program {

	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance(); 
		System.out.println("current time: " + cal1.getTime());
		cal1.add(Calendar.SECOND, 3);
		Task task1 = new Task("take out the trash", cal1);
		
		Calendar cal2 = Calendar.getInstance(); 
		cal2.add(Calendar.SECOND, 10);
		Task task2 = new Task("trash the take out place", cal2);
		
		System.out.println(task1);
		System.out.println();
		System.out.println(task2);
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		
		System.out.println();
		Tasks_Checker_Thread t1 = new Tasks_Checker_Thread(tasks);
		t1.start();
	}
}

package exercise_2_Calender_API_stuff;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		ArrayList<Project> projects = new ArrayList<Project>();
		Scanner scanner = new Scanner(System.in);
		
		
		while (true) {
			
			System.out.println("1> Create new Project\n" + 
					"2> Add task to Project\n" + 
					"3> Print all projects\n" + 
					"4> Exit");
			switch (scanner.nextInt()) {
			case 1:
				Calendar startDate;
				Calendar endDate;
				do {
					startDate = promptDate(true);
				} while (startDate == null);
				do {
					endDate = promptDate(false);
				} while (endDate == null); //
				scanner.nextLine(); // this is to stop scanner's weird behavior from doing weird stuff // remove this and see what happens
				System.out.println("Enter project name");
				String name = scanner.nextLine(); //
				projects.add(new Project(name, startDate, endDate));
				break;
			case 2:
				scanner.nextLine(); // this is to stop scanner's weird behavior from doing weird stuff // remove this and see what happens
				System.out.println("Enter project name to add task to");
				String search = scanner.nextLine();
				for (Project project : projects) { // line 31. works for first name found
					if (project.getName().equals(search)) {
						System.out.println("one task added.\n"
								+ "how long will the task take? (minutes)");
						project.addTask(scanner.nextInt()); // 
						break;
					}
				}
				break;
			case 3:
				System.out.println(projects);
				break;
			case 4:
				System.out.println("Bye");
				scanner.close();
				return;

			default:
				System.out.println("enter a correct input");
				break;
			}
		}
	}
	public static Calendar promptDate(boolean isStartingDate) {
		Scanner scan = new Scanner(System.in); // cant close this i get an exception the second time i call promptDate. idk why
		Calendar date = Calendar.getInstance();
		String str = "";
		// possible errors
		// end date before start date
		// giving strings when ints are required
		if (isStartingDate) {
			str = "starting";
		} else {
			str = "ending";
		}
		try {
			System.out.println("Enter project " + str + " date (year)");
			int year = scan.nextInt();
			System.out.println("Enter project " + str + " date (month)");
			int month = scan.nextInt();
			System.out.println("Enter project " + str + " date (day)");
			int day = scan.nextInt();
			date.set(year, month, day);
		} catch (InputMismatchException e) {
			System.out.println("incorrect input try again");
			return null;
		}
		return date;
	}
}

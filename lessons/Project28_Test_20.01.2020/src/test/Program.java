package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		ReminderThread t1 = new ReminderThread();
		t1.start();
		while (true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("1> Add new reminder\n" + "2> Print all reminders\n" + "3> Exit");
			try {
				switch (scan.nextInt()) {
				case 1:
					System.out.println("Is the reminder important? (yes/no)");
					boolean isImportant = false;
					scan.nextLine(); // flushing scanner
					String isImportantAnswer = scan.nextLine(); // assuming the user enters only yes or no
					if (isImportantAnswer.equalsIgnoreCase("yes"))
						isImportant = true;
					System.out.println("Enter Reminder text");
					String reminderText = scan.nextLine();
					Reminder rem = new Reminder(promptDueDate(), reminderText, isImportant);
					synchronized (rem) {
						reminders.add(rem);
						t1.addReminder(rem);
					}
					break;
				case 2:
					for (Reminder reminder : reminders) {
						System.out.println(reminder);
					}
					break;
				case 3:
					System.out.println("Bye");
					System.exit(0);

				default:
					System.out.println("A valid input is a number between 1 and 3");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("A valid input is a number between 1 and 3");
			}
		}
	}

	@SuppressWarnings("resource")
	public static Calendar promptDueDate() {
		Calendar dueDate;
		Calendar now = Calendar.getInstance();
		Scanner datesScanner = new Scanner(System.in);
		dueDate = Calendar.getInstance();
		while (true) {
			// 
			System.out.println("in how many more days to remind");
			int day = datesScanner.nextInt() + now.get(Calendar.DAY_OF_MONTH);
			System.out.println("in how many more hours to remind");
			int hour = datesScanner.nextInt() + now.get(Calendar.HOUR_OF_DAY);
			System.out.println("in how many more minutes to remind");
			int minute = datesScanner.nextInt() + now.get(Calendar.MINUTE);
			dueDate.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), day, hour, minute);
			System.out.println(dueDate.getTime());
			System.out.println(now.getTime());
			if (dueDate.after(now)) { // if after now
				return dueDate;
			}
			System.out.println("date cant be in the past. try again"); // if user enters negative value
		}
	}
}

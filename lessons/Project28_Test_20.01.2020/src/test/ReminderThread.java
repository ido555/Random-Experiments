package test;

import java.util.ArrayList;
import java.util.Calendar;

public class ReminderThread extends Thread {
	private ArrayList<Reminder> threadReminders;

	public ReminderThread() {
		this.threadReminders = new ArrayList<Reminder>();
	}

	@Override
	public void run() {
		while (true) {
			if (!(threadReminders.isEmpty())) {
				for (Reminder reminder : threadReminders) {
					Calendar now = Calendar.getInstance();
					if (now.after(reminder.getDueDate())) {
						if (!(reminder.isAlreadyReminded())) {
							System.out.println(reminder.getReminderText());
							reminder.setAlreadyReminded();
							if (reminder.isImportant()) {
								ImportantReminderThread reminderThread = new ImportantReminderThread(reminder);
								reminderThread.start();
							}
						}
					}
				}
			}
			try { // wait 1s
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addReminder(Reminder reminder) {
		synchronized (threadReminders) {
			threadReminders.add(reminder);
		}
	}

}

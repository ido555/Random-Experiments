package test;

public class ImportantReminderThread extends Thread {
	private Reminder reminder;

	public ImportantReminderThread(Reminder reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i <= 2; i++) {
				sleep(1000 * 60);
				System.out.println(reminder.getReminderText() + " is past its due date ");
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}

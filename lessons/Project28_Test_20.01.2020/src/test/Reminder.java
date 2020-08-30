package test;

import java.util.Calendar;

public class Reminder{
	private Calendar dueDate;
	private String reminderText;
	private boolean isImportant;
	private boolean alreadyReminded;

	public Reminder(Calendar dueDate, String reminderText, boolean isImportant) {
		this.dueDate = dueDate;
		this.reminderText = reminderText;
		this.isImportant = isImportant;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public String getReminderText() {
		return reminderText;
	}

	public boolean isImportant() {
		return isImportant;
	}

	public boolean isAlreadyReminded() {
		return alreadyReminded;
	}
	public void setAlreadyReminded() {
		this.alreadyReminded = true;
	}

	@Override
	public String toString() {
		return "Reminder [dueDate=" + dueDate.getTime() + ", reminderText=" + reminderText + ", isImportant=" + isImportant
				+ ", alreadyReminded=" + alreadyReminded + "]";
	}
	
}

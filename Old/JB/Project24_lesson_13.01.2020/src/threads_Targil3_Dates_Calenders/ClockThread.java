package threads_Targil3_Dates_Calenders;

import java.util.Calendar;

public class ClockThread extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				Calendar cal = Calendar.getInstance();
				
				int hour = cal.get(Calendar.HOUR_OF_DAY);
				int minute = cal.get(Calendar.MINUTE);
				int second = cal.get(Calendar.SECOND);
				System.out.println((hour < 10 ? "0" + hour: hour) + ":" +
						((minute < 10 ? "0" + minute: minute) + ":") + 
						(second < 10 ? "0" + second: second));
				sleep(1000);
			} catch (InterruptedException e) {
				// 
				e.printStackTrace();
			}
		}
	}
}

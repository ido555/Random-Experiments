package threads_ex3_Calender;

import java.util.Calendar;
import java.util.Random;

public class Calender_Thread extends Thread {
	private Calendar cal;
	private Random rand;

	public Calender_Thread() {
		cal = Calendar.getInstance();
		rand = new Random();
	}

	@Override
	public void run() {
		try {
			while (true) {
				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, rand.nextInt(9) + 1);
				System.out.println(cal.getTime());
				Thread.sleep(rand.nextInt(1000) + 1000); // 1000 - 2000
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

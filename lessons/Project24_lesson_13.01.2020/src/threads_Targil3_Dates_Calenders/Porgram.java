package threads_Targil3_Dates_Calenders;

import java.util.Calendar;

public class Porgram {

	public static void main(String[] args) {
		
		//Date - old dont use
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		cal.set(2225, 6, 11, 11, 55, 12);
		System.out.println(cal.getTime());
		cal.set(1969, cal.JANUARY, cal.MONDAY);
		System.out.println(cal.getTime());
		
		//reset cal
		cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 17); // change day in month
		System.out.println(cal.getTime());
		
		ClockThread clock = new ClockThread();
		clock.start();
	}

}

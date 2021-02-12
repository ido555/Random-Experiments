package threads_Targil_2;

public class Prime_Thread extends Thread {
	int min, max, count = 0;

	public Prime_Thread(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {

		for (int i = min; i < max; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		//System.out.println(count);
	}
	public static boolean isPrime(int num) {
		   if (num <= 1) {
		       return false;
		   }
		   for (int i = 2; i <= Math.sqrt(num); i++) {
		       if (num % i == 0) {
		           return false;
		       }
		   }
		   return true;
	}
	public int getCount() {
		return count;
	}
}

package threads3;

public class DividersThread extends Thread {
	// count how many dividers between 2 numbers

	private int min, max, number;

	public DividersThread(int min, int max, int divider) {
		super();
		this.min = min;
		this.max = max;
		this.number = divider;
	}

	@Override
	public void run() {
		int count = 0;
		for (int i = min; i < max; i++) {
			if (number % i == 0) {
				 System.out.println(i + " divides with " + number + " without remainder");
				count++;
			}
		}
		System.out.println("number of dividers without remainder: " + count);
	}

}

package threads6_sync;

import java.util.ArrayList;
import java.util.Random;

public class Numbers_Thread extends Thread {
	// create thread referencing ArrayList, adds 50 random numbers to the list
	private ArrayList<Integer> nums;
	private Random rand = new Random();

	public Numbers_Thread(ArrayList<Integer> nums) {
		this.nums = nums;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5000000; i++) {
			synchronized (nums) { // no one can change me until the thread is done with me
				nums.add(rand.nextInt(99) + 1);
			}
			// nums is no longer locked to a thread
			// nums is released to another thread
			//System.out.println("added: " + nums.get(i));
		}
	}
	public synchronized void addNum(int num) {
		
	}
}

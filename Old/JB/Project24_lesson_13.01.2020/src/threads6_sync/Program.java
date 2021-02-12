package threads6_sync;

import java.util.ArrayList;

public class Program extends Thread {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Numbers_Thread t1 = new Numbers_Thread(numbers);
		t1.start();
		Numbers_Thread t2 = new Numbers_Thread(numbers);
		t2.start();
		// both threads try to add at the exact same time
		// and one creates a new space and the other jumps in then the first one overwrites the second one
		// and a number is lost
		// now we added sync
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("size: "+numbers.size());
		System.out.println(end - start + "ms");
	}

}

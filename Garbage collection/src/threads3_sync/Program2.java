package threads3_sync;

import java.util.List;
import java.util.Vector;

public class Program2 {

	public static void main(String[] args) {
		// Vector is exactly the same as an ArrayList but synchronized (but in method level)
		List<String> data = new Vector<String>();
		Worker1 worker1 = new Worker1(data);
		Worker1 worker2 = new Worker1(data);
		worker1.start();
		worker2.start();
		try {
			worker1.join();
			worker2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("size: " + data.size());
	}

}

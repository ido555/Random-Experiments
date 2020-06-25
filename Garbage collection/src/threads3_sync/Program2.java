package threads3_sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Program2 {

	public static void main(String[] args) {
		List<String> data = new Vector<String>();
		Worker2 worker1 = new Worker2(data);
		Worker2 worker2 = new Worker2(data);
		
		worker1.start(); worker2.start();
		
		try {
			worker2.join(); // make Main Thread wait for worker2 to finish!
			worker1.join();
		} catch (InterruptedException e) {}
		System.out.println("size: " + data.size());

	}

}

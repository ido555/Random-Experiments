package threads3_sync;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
		Worker1 worker1 = new Worker1(data);
		Worker1 worker2 = new Worker1(data);
		
		worker1.start(); worker2.start();
		
		try {
//			Thread.sleep(2000);
			worker2.join(); // make Main Thread wait for worker2 to finish!
			worker1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("size: " + data.size());

	}

}

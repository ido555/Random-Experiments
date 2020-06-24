package threads3_wait;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
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

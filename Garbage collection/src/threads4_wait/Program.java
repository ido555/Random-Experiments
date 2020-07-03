package threads4_wait;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
		WriterWorker worker1 = new WriterWorker(data);
		ReaderWorker worker2 = new ReaderWorker(data);
		ReaderWorker worker3 = new ReaderWorker(data);

		//worker3.setPriority(10);
		
		worker1.start();
		worker2.start();
		worker3.start();
		
		try {
			worker1.join();
		} catch (InterruptedException e) {}
		
		while(data.size() != 0) {
			data.notifyAll();
		}
		
	}

}

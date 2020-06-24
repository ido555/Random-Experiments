package threads4_wait;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();
		WriterWorker worker1 = new WriterWorker(items);
		ReaderWorker worker2 = new ReaderWorker(items);
		worker1.start();
		worker2.start();
	}

}

package threads4_wait;

import java.util.List;

public class WriterWorker extends Thread {
	private List<String> items;

	public WriterWorker(List<String> items) {
		super();
		this.items = items;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (items) {
				items.add("Item " + (i + 1));
				items.notify();
			}
		}
	}
}
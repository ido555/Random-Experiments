package threads5_daemon;

import java.util.List;

public class Worker1 extends Thread {
	private List<String> items;

	public Worker1(List<String> items) {
		super();
		this.items = items;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (items) {
				items.add("Item " + i + 1);
			}
		}
	}
}

package threads3_sync;

import java.util.List;

public class Worker2 extends Thread {
	private List<String> items;

	public Worker2(List<String> items) {
		super();
		this.items = items;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
				items.add("Item " + i + 1);
		}
	}
}

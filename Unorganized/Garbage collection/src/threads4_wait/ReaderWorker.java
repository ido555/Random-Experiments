package threads4_wait;

import java.util.List;

public class ReaderWorker extends Thread {

	private List<String> items;

	public ReaderWorker(List<String> items) {
		super();
		this.items = items;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (items) {
				while (items.size() == 0) {
					try {
						items.wait();
					} catch (InterruptedException e) {}
				}
			}
			System.out.println(items.remove(0));
		}
	}

}

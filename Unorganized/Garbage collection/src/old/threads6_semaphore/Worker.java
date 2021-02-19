package old.threads6_semaphore;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {

	private Semaphore semaphore;

	public Worker(Semaphore semaphore, String name) {
		super(name);
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire(); // get one lock from the semaphore if available

			for (int i = 0; i < 5; i++) {
				System.out.println(getName() + " " + (i + 1));
				try {
					sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}

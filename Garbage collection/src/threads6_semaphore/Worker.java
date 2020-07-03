package threads6_semaphore;

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
			semaphore.acquire(); // get one permit from the semaphore if available.
			System.out.println(getName() + " is starting:");
			for (int i = 0; i < 5; i++) {
				System.out.println(getName() + " " + (i + 1));
				try {
					sleep(400);
				} catch (InterruptedException e) {}
			}
			
		} catch (InterruptedException e) {}
		finally {
			System.out.println(getName() + " ended!");
			semaphore.release(); // return the permit to the semaphore
		}
	}

}

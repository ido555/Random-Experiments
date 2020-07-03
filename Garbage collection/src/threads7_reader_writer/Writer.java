package threads7_reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Writer extends Thread {

	private ReentrantReadWriteLock lock;

	public Writer(ReentrantReadWriteLock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {

		lock.writeLock().lock(); // lock as writer!
		System.out.println("writing...");
		try {
			sleep(1500);
		} catch (InterruptedException e) {
		} finally {
			lock.writeLock().unlock(); // release writer lock
		}
	}

}

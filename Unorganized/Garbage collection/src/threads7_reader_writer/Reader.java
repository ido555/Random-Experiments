package threads7_reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader extends Thread {
	private ReentrantReadWriteLock lock;

	public Reader(ReentrantReadWriteLock lock, String name) {
		super(name);
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.readLock().lock(); // get reader lock!
		System.out.println(getName() + " is reading...");
		try {
			sleep(300);
		} catch (InterruptedException e) {}
		finally {
			lock.readLock().unlock(); // release the reader lock
		}
	}
}

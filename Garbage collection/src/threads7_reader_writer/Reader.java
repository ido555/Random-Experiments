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
		lock.readLock().lock(); // lock everything but readers
		System.out.println(getName() + " is reading...");
			lock.readLock().unlock(); // release
			try {
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}

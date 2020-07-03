package old.threads7_reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Writer extends Thread {
	
	private ReentrantReadWriteLock lock;
	
	public Writer(ReentrantReadWriteLock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
//		lock.readLock();
		lock.writeLock().lock(); // locks everything but itself
		System.out.println("writing...");
		try {
			sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock(); // release
		}
		
	}
}

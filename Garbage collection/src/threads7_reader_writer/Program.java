package threads7_reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Program {

	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		Reader r1 = new Reader(lock, "reader1");
		Reader r2 = new Reader(lock, "reader2");
		Reader r3 = new Reader(lock, "reader3");
		Reader r4 = new Reader(lock, "reader4");
		Writer w1 = new Writer(lock);
		Writer w2 = new Writer(lock);
		Writer w3 = new Writer(lock);
		Writer w4 = new Writer(lock);
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		w1.start();
		w2.start();
		w3.start();
		w4.start();
	}

}

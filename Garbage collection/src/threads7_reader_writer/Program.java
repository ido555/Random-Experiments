package threads7_reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Program {

	public static void main(String[] args) {

		ReentrantReadWriteLock myLock = new ReentrantReadWriteLock();
		Reader r1 = new Reader(myLock, "reader1");
		Writer w1 = new Writer(myLock);
		Writer w2 = new Writer(myLock);
		Reader r2 = new Reader(myLock, "reader2");
		Reader r3 = new Reader(myLock, "reader3");
		Reader r4 = new Reader(myLock, "reader4");
		
		w1.start();r1.start();w2.start();r2.start();r3.start();r4.start();
		
		
	}

}

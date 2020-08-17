package threads1;

public class Program { // to actually run the thread
	public static void main(String[] args) {
		Thread t1 = new Thread(new MySimpleThread()); // must give Thread a class to run
		Thread t2 = new Thread(new MySimpleThread());
		t1.start(); // run in parallel! this will call run(), not directly though, it actually does
					// more in the background
		// t1.run(); doesn't actually run in parallel;
		t2.start();
		System.out.println("the end?"); // using the main thread. t1 is running in parallel
	}
}

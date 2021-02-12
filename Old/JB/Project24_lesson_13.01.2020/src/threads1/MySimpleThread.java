package threads1;

public class MySimpleThread implements Runnable { // option 1 to create threads

	public void run() {
		System.out.println("I am in a thread!");
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);

//			// a long running loop
//			for (long j = 0; j < 1_000_000_000L; j++) {
//			}
			// a long running loop
			// Thread.sleep
			// ^
			// try catch exception
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Thread end");
	}

}

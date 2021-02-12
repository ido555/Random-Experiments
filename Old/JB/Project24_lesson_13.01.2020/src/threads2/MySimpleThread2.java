package threads2;

public class MySimpleThread2 extends Thread { // option 2
	// must override run
	@Override
	public void run() {
		System.out.println("I am in a thread!");
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {

			}
		}
		System.out.println("Thread end");
	}

}

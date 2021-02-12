package threads1;

public class Worker1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("i=" +i);
			try {
				sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	
}

package threads2_sleep;

public class Worker1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("i=" +i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Someone interrupted my sleep :(");
				break;
			}
		}
	}
	
}

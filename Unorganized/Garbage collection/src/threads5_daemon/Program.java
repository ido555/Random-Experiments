package threads5_daemon;

public class Program {

	public static void main(String[] args) {

		Worker1 worker = new Worker1();
		worker.setDaemon(true);
		worker.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		System.out.println("Main is ending...");
	}

}

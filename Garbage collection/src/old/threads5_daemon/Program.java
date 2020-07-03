package old.threads5_daemon;

public class Program {

	public static void main(String[] args) {
		Worker1 worker = new Worker1(null);
		worker.setDaemon(true);
		// setDaemon dies with the thread that created it - Main
		worker.start();
		
		System.out.println("Main is ending...");
	}

}

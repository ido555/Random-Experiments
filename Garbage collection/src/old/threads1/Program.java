package old.threads1;

public class Program {

	public static void main(String[] args) {
		Worker1 worker1 = new Worker1();
		worker1.start();
		Thread worker2 = new Thread(new Worker2());
		worker2.start();
	}

}

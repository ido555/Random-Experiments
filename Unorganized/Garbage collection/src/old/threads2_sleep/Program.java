package old.threads2_sleep;

public class Program {

	public static void main(String[] args) {
		Worker1 worker1 = new Worker1();
		worker1.start();
		worker1.interrupt();
	}

}

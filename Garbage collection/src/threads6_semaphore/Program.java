package threads6_semaphore;

import java.util.concurrent.Semaphore;

public class Program {

	public static void main(String[] args) {

		Semaphore s = new Semaphore(2);
		Worker w1 = new Worker(s, "w1");
		Worker w2 = new Worker(s, "w2");
		Worker w3 = new Worker(s, "w3");
		Worker w4 = new Worker(s, "w4");
		Worker w5 = new Worker(s, "w5");
		Worker w6 = new Worker(s, "w6");
		Worker w7 = new Worker(s, "w7");
		
		w1.start();w2.start();w3.start();w4.start();w5.start();w6.start();w7.start();
		
		
	}

}

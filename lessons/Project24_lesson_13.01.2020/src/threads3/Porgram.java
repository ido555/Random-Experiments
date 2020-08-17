package threads3;

public class Porgram {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		DividersThread t1 = new DividersThread(1, 100_000_000, 300_000_000);
//		DividersThread t2 = new DividersThread(100_000_001, 200_000_000, 300_000_000);
//		DividersThread t3 = new DividersThread(200_000_001, 300_000_000, 300_000_000);
		
		DividersThread t1 = new DividersThread(1, 100_000_000, 300_000_000);
		t1.start();
		

//		t1.start();
//		t2.start();
//		t3.start();
		//long end = System.currentTimeMillis(); not correct have to wait for t1 to finish running in parallel
		// continue only after t1 finished

		try {
			t1.join(); // wait for t1 to finish
//			t2.join(); // wait for t2 to finish
//			t3.join(); // wait for t3 to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("took: " + (end - start) + "ms");

	}

}

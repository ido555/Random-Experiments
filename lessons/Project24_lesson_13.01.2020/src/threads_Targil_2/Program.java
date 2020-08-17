package threads_Targil_2;

public class Program {

	public static void main(String[] args) {
		// Prime_Thread t1 = new Prime_Thread(1, 12500);
		// t1.start();
		long start = System.currentTimeMillis();
		Prime_Thread t1 = new Prime_Thread(1, 2_500_000);
		t1.start();
		Prime_Thread t2 = new Prime_Thread(2_500_001, 5_000_000);
		t2.start();
		Prime_Thread t3 = new Prime_Thread(2_500_001, 5_000_000);
		t3.start();
		Prime_Thread t4 = new Prime_Thread(5_000_001, 7_500_000);
		t4.start();
		Prime_Thread t5 = new Prime_Thread(7_500_001, 10_000_000);
		t5.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (Exception e) {
		}
		
		long end = System.currentTimeMillis();
		// count is wrong idk why, fuck this
		int total = t1.getCount() + t2.getCount() + t3.getCount() + t4.getCount() + t5.getCount();
		System.out.println(total);
		System.out.println(end - start + "ms");
	}

}

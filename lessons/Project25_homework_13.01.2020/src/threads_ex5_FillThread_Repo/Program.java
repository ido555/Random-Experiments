package threads_ex5_FillThread_Repo;

public class Program {

	public static void main(String[] args) {
		Repository rep = new Repository();
		FillThread filler1 = new FillThread(rep);
		FillThread filler2 = new FillThread(rep);
		FillThread filler3 = new FillThread(rep);
		FillThread filler4 = new FillThread(rep);
		filler1.start();
		filler2.start();
		filler3.start();
		filler4.start();
		
		try {
			filler1.join();
			filler2.join();
			filler3.join();
			filler4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(rep.getNums()); // loop number instead of random number to help visualize how many threads were involved
		// for me its 2 or 3 threads usually
		
	}

}

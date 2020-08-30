package threads_ex5_FillThread_Repo;

//import java.util.Random;

public class FillThread extends Thread {
	private Repository rep;

	public FillThread(Repository rep) {
		this.rep = rep;
	}

	@Override
	public void run() {
		// repository size = 10 also if 4 threads
		//Random rand = new Random();
		// rand.nextInt(20) + 10

		for (int i = 0; i < 10; i++) {
			synchronized (rep) {
				if (rep.getNums().size() < 10) {
					rep.addNum(i);
				} else {
					return;
				}
			}
		}

	}

}

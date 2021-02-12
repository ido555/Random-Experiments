package threads_Targil;

public class My_Thread extends Thread {
	// String name = "name " + ((int)(Math.random()*10)+1);
	String name;

	public My_Thread(String name) {
		this.name = name;
	}
 
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " run number: " + i);
			try {
				Thread.sleep((int) ((Math.random() * 1000) + 1));
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}

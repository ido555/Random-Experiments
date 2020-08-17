package threads_ex1_Name_Printer;

public class Name_Thread extends Thread{
	private String name;

	public Name_Thread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(name);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}

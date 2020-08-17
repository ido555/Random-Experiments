package threads_ex2_Word_Flipper;

public class Word_Flipper_Thread extends Thread {
	private String text;

	public Word_Flipper_Thread(String text) {
		this.text = text;
	}

	@Override
	public void run() {
		for (int i = text.length()-1; i >= 0; i--) {
			System.out.println(text.charAt(i));
		}
	}
}

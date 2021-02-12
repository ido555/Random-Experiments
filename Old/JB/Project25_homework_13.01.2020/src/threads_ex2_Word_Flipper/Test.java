package threads_ex2_Word_Flipper;

public class Test {

	public static void main(String[] args) {
		Word_Flipper_Thread t1 = new Word_Flipper_Thread("rope");
		Word_Flipper_Thread t2 = new Word_Flipper_Thread("rope");
		t1.start();
		t2.start();
	}

}

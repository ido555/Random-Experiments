package threads_ex3_Calender;

public class Test {

	public static void main(String[] args) {
		Calender_Thread t1 = new Calender_Thread();
		Calender_Thread t2 = new Calender_Thread();
		Calender_Thread t3 = new Calender_Thread();
		t1.start();
		t2.start();
		t3.start();
	}

}

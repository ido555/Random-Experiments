package threads_Targil;

public class Program {

	public static void main(String[] args) {
		My_Thread t1 = new My_Thread("jeff");
		My_Thread t2 = new My_Thread("mark");
		t1.start();
		t2.start();
	}

}

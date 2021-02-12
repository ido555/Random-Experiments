package threads2;

public class Program {

	public static void main(String[] args) {
		MySimpleThread2 t1 = new MySimpleThread2(); // now can't inherit from other classes :( 
		// the interfaced one can inherit; this one is a little simpler though
		t1.start();
		MySimpleThread2 t2 = new MySimpleThread2();
		t2.start();
		MySimpleThread2 t3 = new MySimpleThread2();
		t3.start();
		MySimpleThread2 t4 = new MySimpleThread2();
		t4.start();
	}

}

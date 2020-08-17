package threads_ex1_Name_Printer;

public class Test {

	public static void main(String[] args) {
	Name_Thread t1 = new Name_Thread("aaaaa");	
	Name_Thread t2 = new Name_Thread("bbbbb");	
	Name_Thread t3 = new Name_Thread("ccccc");	
	t1.start();
	t2.start();
	t3.start();
	}

}

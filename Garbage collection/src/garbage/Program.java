package garbage;

public class Program {

	public static void main(String[] args) {

		Dog myDog = new Dog("Dubi", 14);
		System.out.println(myDog);
		
		myDog = null;
		
		// RUN THE GARBAGE COLLECTOR!
		System.gc();
		
		System.out.println(myDog);
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

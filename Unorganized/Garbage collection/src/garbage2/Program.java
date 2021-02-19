package garbage2;

import java.lang.ref.WeakReference;

public class Program {

	public static void main(String[] args) {

		//StrongReference();

		weakReference();
				
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
	}
	
	public static void weakReference() {
		
		Dog myDog = new Dog("Dubi", 10);
		WeakReference<Dog> dog2 = new WeakReference<Dog>(myDog);
		
		System.out.println("Before null: " + dog2.get());
		myDog = null;
		System.gc();
		
		System.out.println("After null: " + dog2.get());
		
	}
	
	public static void StrongReference() {
		Dog myDog = new Dog("Dubi", 10);
		
		Dog dog2 = myDog;
		myDog = null;
		
		System.gc();
		
	}

}

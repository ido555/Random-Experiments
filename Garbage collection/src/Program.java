import java.lang.ref.WeakReference;

public class Program {

	public static void main(String[] args) {
//		StrongReference();
		WeakReference();
	}
	
	
	public static void WeakReference() {
		Dog myDog = new Dog(14, "Dubi");
		WeakReference<Dog> dog2 = new WeakReference<Dog>(myDog);
		myDog = null;
		System.gc();
		System.out.println(dog2.get());
		
	}
	
	public static void StrongReference() {
		Dog myDog = new Dog(14, "Dubi");
		Dog myDog2 = myDog;
		// myDog = null
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
                                                                     
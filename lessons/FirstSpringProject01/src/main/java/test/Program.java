package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import beans.Pet;
import beans.Phone;

public class Program {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)) { // Spring stuff
			Pet myPet1 = ctx.getBean(Pet.class);
			myPet1.setAge(1);
			myPet1.setName("aaaa");
			myPet1.setType("aaaaa");
			System.out.println(myPet1);
			Pet myPet2 = ctx.getBean(Pet.class, "bbbb", "bbbbb", 2); // CTOR
			System.out.println(myPet2);
			System.out.println(myPet1);
			
			/*
			 * Create a phone bean
			 * model, manufacturer, color, price
			 * create 2 different phone objects in main using Spring
			 */
			
			Phone myPhone1 = ctx.getBean(Phone.class, 600, "iPhone X", "red", "Apple");
			Phone myPhone2 = ctx.getBean(Phone.class, 600, "iPhone Z", "blue", "Grapple");
			System.out.println(myPhone1);
			System.out.println(myPhone2);
			
			/*
			 * Create a singleton PhoneStore bean:
			 * Name, address
			 * add the PhoneStore to the Phone class
			 */
		}
		// Regular java
		Pet mypet = new Pet("a", "dog", 10);
		System.out.println(mypet);
	}
}

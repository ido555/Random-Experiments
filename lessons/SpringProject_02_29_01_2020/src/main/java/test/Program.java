package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Pet;
import beans.Vet;

public class Program {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new ClassPathXmlApplicationContext("test/SpringConfig.xml")) { // Spring stuff
			Pet myPet1 = (Pet) ctx.getBean("myPet1");
			System.out.println(myPet1);
			Pet myPet2 = (Pet) ctx.getBean("myPet2");
			System.out.println(myPet2);
			
			Vet vet = (Vet) ctx.getBean("vet1");
			System.out.println(vet);
		}
	}

}

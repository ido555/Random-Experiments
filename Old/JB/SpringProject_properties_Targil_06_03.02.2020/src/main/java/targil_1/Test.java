package targil_1;

//import java.util.Random;
//import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class Test {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)) {
			Environment env = ctx.getBean(Environment.class);
//			ex 1.
//			Random rand = new Random();
//			int max = env.getRequiredProperty("max_value", Integer.class);
//			int min = env.getRequiredProperty("min_value", Integer.class);
//			int difference = max - min;
//			int secNum = rand.nextInt(difference) + min;
//			System.out.println(secNum);
//			int maxGuesses = env.getRequiredProperty("num_of_tries", Integer.class);
//			Scanner scan = new Scanner(System.in);
//			for (int i = 0; i < maxGuesses; i++) {
//				if (scan.nextInt() == secNum) {
//					System.out.println("correct");
//					break;
//				}
//				System.out.println("try again");
//			}
			
		}
	}
}

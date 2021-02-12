package beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)) {
		}
	}
}

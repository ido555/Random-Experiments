package pokAnimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			PokDBDAO pokDB = ctx.getBean(PokDBDAO.class);
			pokDB.addPok(new Pok(55, 1235, "jeff2", PokType.Air));
			System.out.println(pokDB.getAllPoks());
		}
	}

}

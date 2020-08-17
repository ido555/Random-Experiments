package lesson;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Product;
import db.ProductsDBDAO;

public class Test {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(SpringConfig.class)) {
			ProductsDBDAO prodDB = ctx.getBean(ProductsDBDAO.class);
			for (Product product : prodDB.getAllProducts()) {
				System.out.println(product);
			}
			System.out.println("================================================");
			System.out.println(prodDB.getOneProduct(1));
//			prodDB.deleteProduct(99);
		}
	}
}

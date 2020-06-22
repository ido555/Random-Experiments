package d01_factory;

public class Program {

	public static void main(String[] args) {
		
		
		Shape s1 = ShapesFactory.createShape();
		s1.print();
		
		Circle c1 = (Circle) ShapesFactory.createShape("circle");
		c1.print();
	}

}

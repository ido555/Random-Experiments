import java.util.ArrayList;
import java.util.Random;

public class Test_2 {
// writing this code i generally went more for shorter code and more readable rather than efficient code
	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			Point p1 = new Point(rand.nextInt(100), rand.nextInt(100));
			Point p2 = new Point(rand.nextInt(100), rand.nextInt(100));
			Point p3 = new Point(rand.nextInt(100), rand.nextInt(100));
			Point p4 = new Point(rand.nextInt(100), rand.nextInt(100));
			int rand1 = rand.nextInt(100);
			int rand2 = rand.nextInt(100);
			int rand3 = rand.nextInt(100);
			ArrayList<Point> pointsTmp = new ArrayList<Point>();
			switch (rand.nextInt(3)) {
			//  
			// right now everything is red but i will add a color array to choose from later
			case 0: // rectangle
				pointsTmp.add(p1); pointsTmp.add(p2); pointsTmp.add(p3); pointsTmp.add(p4);
				Rectangle rect = new Rectangle(rand1, rand2, "red", pointsTmp);
				shapes.add(rect);
				break;
			case 1: // circle
				Circle circle = new Circle(rand1, rand2, rand3, "red");
				shapes.add(circle);
				break;
			case 2: // triangle
				pointsTmp.add(p1); pointsTmp.add(p2); pointsTmp.add(p3);
				Triangle triangle = new Triangle(pointsTmp, "red", rand1, rand2);
				shapes.add(triangle);
				break;
			}
		}
		for (Shape shape : shapes) {
			System.out.println(shape);
			
		}
		System.out.println("\n\n\n");
		for (Shape shape : shapes) {
			shape.moveShape(5000, 5000);
			System.out.println(shape);
		}
		
	}
}

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point(5, 420);
		Point p2 = new Point(1337, 555);
		Point p3 = new Point(667, 26);
		//Point p1 = new Point(-2, 5);
		
		System.out.println(p1.toString());
		p1.changeY(-5);
		System.out.println(p1.toString());
		//p.setY(-1);
		System.out.println();
		Circle cir = new Circle(2, 6, 5.5, "red");
		System.out.println(cir.toString());
		cir.setColor("matala-ish purple");
		System.out.println(cir.toString());
		cir.setColor("GOLD");
		cir.setRadius(1.61803398875);
		cir.moveShape(5, -2);
		System.out.println(cir.toString());
		//cir.moveShape(5, -10000);
		
		System.out.println();
		ArrayList<Point> _3points = new ArrayList<Point>();
		_3points.add(p1);
		_3points.add(p2);
		_3points.add(p3);
		Triangle triangle = new Triangle(_3points, "red", 5, 9);
		System.out.println(triangle.toString());
		
		triangle.moveShape(2, 22);
		System.out.println(triangle.toString());
		
		
		System.out.println();
		ArrayList<Point> _4points = new ArrayList<Point>();
		_4points.add(p1);
		_4points.add(p2);
		_4points.add(p3);
		_4points.add(p1);
		Rectangle rect = new Rectangle(15, 12, "red", _4points);
		System.out.println(rect.toString());
		rect.setColor("purple");
		rect.moveShape(15, 1);
		//rect.moveShape(-125, 1);
		System.out.println(rect.toString());
	}

}

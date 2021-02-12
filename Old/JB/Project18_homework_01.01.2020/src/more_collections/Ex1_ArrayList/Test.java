package more_collections.Ex1_ArrayList;

import java.util.ArrayList;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		ArrayList<Circle> circles = new ArrayList<Circle>();
		Random rand = new Random();

		while (true) { // add circles until radius > 90. enter that larger radius circle then end
			int radius = rand.nextInt(90)+10; // 0 - 90 + 10  =  10 - 100
			Circle circle = new Circle("aa", radius);
			circles.add(circle);
			if (radius > 90) {
				break;
			}
		}
		for (Circle circle : circles) {
			System.out.println(circle.toString());
		}
	}
}

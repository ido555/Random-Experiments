package d01_factory;

public class ShapesFactory {

	public static Shape createShape() {
		
		switch( rnd(1, 3) ) {
		case 1:
			// rectangle
			return new Rectangle(rnd(1,10), rnd(1,10), rnd(1,400), rnd(1,400));
		
		case 2:
			// circle
			return new Circle(rnd(1,10), rnd(1,10), rnd(1,100));
			
		case 3:
			// triangle
			return new Triangle(rnd(1,10), rnd(1,10), rnd(1,400), rnd(1,300));
			
		}
		
		return null;
	}
	
	private static int rnd(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}
	
	
	public static Shape createShape(String shapeType) {
		switch (shapeType) {
		case "circle":
			return new Circle(rnd(1,10), rnd(1,10), rnd(1,100));
		case "rectangle":
			return new Rectangle(rnd(1,10), rnd(1,10), rnd(1,400), rnd(1,400));
		case "triangle":
			return new Triangle(rnd(1,10), rnd(1,10), rnd(1,400), rnd(1,300));

		default:
			return null;
		}
	}
}









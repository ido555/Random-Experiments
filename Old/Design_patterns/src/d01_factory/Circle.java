package d01_factory;

public class Circle extends Shape {

	private int radius;

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void print() {
		System.out.println("Circle - X = " + getX() + ", Y = " + getY() + ", Radius = " + radius);
	}

}

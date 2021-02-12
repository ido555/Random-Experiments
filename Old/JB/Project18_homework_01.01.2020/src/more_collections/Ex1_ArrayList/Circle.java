package more_collections.Ex1_ArrayList;

public class Circle {
	private String color;
	private int radius;

	public Circle(String color, int radius) {
		this.color = color;
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [color=" + color + ", radius=" + radius + "]";
	}

}

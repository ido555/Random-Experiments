
public class Circle extends Shape {
	private double radius;

	public Circle(int x, int y, double radius, String color) {
		this.color = color;
		points.add(new Point(x, y));
		
		setRadius(radius);
	}

	@Override
	double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	void moveShape(int moveX, int moveY) {
		for (Point point : points) {
			point.changeX(moveX);
			point.changeY(moveY);
		}
	}

	public void setRadius(double radius) {
		try {
			// one liners dont need {}
			if (radius >= 0.0)
				this.radius = radius;
			else
				throw new NegativeNumberException();

		} catch (NegativeNumberException e) {
			e.printStackTrace(); // for debugging
			System.exit(-1); // stop program completely // for debugging
		}

	}

	public double getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", points=" + points + ", color=" + color + ", calcArea()=" + calcArea()
				+ "]";
	}

	@Override
	public void setColor(String color) {
		super.setColor(color);
	}

	@Override
	public String getColor() {
		return super.getColor();
	}
}

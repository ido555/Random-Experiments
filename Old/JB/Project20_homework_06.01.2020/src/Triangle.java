import java.util.ArrayList;

public class Triangle extends Shape {
	double baseLength;
	double height;

	public Triangle(ArrayList<Point> points, String color, double baseLength, double height) {

		try {
			// one liners dont need {}
			if (points.size() != 3)
				throw new InvalidAmountOfPointException("3", points.size());
			else if (!(baseLength >= 0 && height >= 0))
				throw new NegativeNumberException();
		} catch (InvalidAmountOfPointException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		for (Point point : points) {
			this.points.add(point);
		}
		this.baseLength = baseLength;
		this.height = height;
		setColor(color); // no error checking

	}

	@Override
	double calcArea() {
		// wrong because of a problem with the excersise given. coordinates and
		// base/height are directly connected
		// need to incorporate Heron's formula
		return baseLength * (height / 2);
	}

	@Override
	void moveShape(int moveX, int moveY) {
		for (Point point : this.points) {
			point.changeX(moveX);
			point.changeY(moveY);
		}

	}

	@Override
	public String toString() {
		return "Triangle [baseLength=" + baseLength + ", height=" + height + ", color=" + color
				+ ", (incorrect)calcArea()=" + calcArea() +  ", points=" + points + "]";
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

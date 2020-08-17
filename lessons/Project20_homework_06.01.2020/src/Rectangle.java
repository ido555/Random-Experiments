import java.util.ArrayList;

public class Rectangle extends Shape {
	private int height;
	private int width;

	public Rectangle(int height, int width, String color, ArrayList<Point> points) {
		try {
			if (points.size() != 4)
				throw new InvalidAmountOfPointException("4", points.size());
			else if (!(width >= 0 && height >= 0))
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
		this.height = height;
		this.width = width;
		setColor(color);
	}

	@Override
	double calcArea() {
		// need to calculate by distance from coordinates. not doing that right now
		return height * width;
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
		return "Rectangle[height=" + height + ", width=" + width + ", color=" + color
				+ ", (incorrect)calcArea()=" + calcArea() + ", Rectangle [points=" + points + "]";
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
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

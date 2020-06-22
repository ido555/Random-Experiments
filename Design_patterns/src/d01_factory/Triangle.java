package d01_factory;

public class Triangle extends Shape {

	private int height, base;

	public Triangle(int x, int y, int height, int base) {
		super(x, y);
		this.height = height;
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	@Override
	public void print() {
		System.out.println("Triangle - X = " + getX() + ", Y = " + getY() + ", Height = " + height + ", Base = " + base);
	}

}

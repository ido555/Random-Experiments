import java.util.ArrayList;

public abstract class Shape {
	ArrayList<Point> points = new ArrayList<Point>();
	String color;
	abstract double calcArea();
	
	abstract void moveShape(int moveX , int moveY); // should be ints since Point objects x,y are to be moved and they are ints
	
	public void setColor(String color) { // no error checking
		this.color = color;
	}
	public String getColor() {
		return color;
	}
}

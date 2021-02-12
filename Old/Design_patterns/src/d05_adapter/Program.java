package d05_adapter;

public class Program {

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(1, 1, 5, 5);
		System.out.println(rect1);
		
		ModernRectangle rect2 = new ModernRectangle(1, 1, 4, 4);
		System.out.println(rect2.getX2() + ", " + rect2.getY2());
	}

}

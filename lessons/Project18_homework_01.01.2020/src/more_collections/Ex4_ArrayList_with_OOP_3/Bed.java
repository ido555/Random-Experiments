package more_collections.Ex4_ArrayList_with_OOP_3;

public class Bed extends Furniture {
	private boolean isKingSize;

	public Bed(int length, int width, int height, String color, boolean isKingSize) {
		super(length, width, height, color); // mouse over "super" and press f3 to see where it goes
		this.isKingSize = isKingSize;
	}

	@Override
	public void draw() {
		System.out.println("   ||");
		System.out.println("   ||                   ||");
		System.out.println("||/||___                ||");
		System.out.println("|| /`   )____________||_/|");
		System.out.println("||/___ //_/_/_/_/_/_/||/ |");
		System.out.println("||(___)/_/_/_/_/_/_/_||  |");
		System.out.println("||     |_|_|_|_|_|_|_|| /|");
		System.out.println("||     | | | | | | | ||/||");
		System.out.println("||~~~~~~~~~~~~~~~~~~~||");
		System.out.println("||                   ||");
	}

	public void setKingSize(boolean isKingSize) {
		this.isKingSize = isKingSize;
	}

	public boolean isKingSize() {
		return isKingSize;
	}

	@Override
	public String toString() {
		return "Bed [isKingSize=" + isKingSize + ", Length=" + getLength() + ", Width=" + getWidth() + ", Height="
				+ getHeight() + ", Color=" + getColor() + "]";
	}

}

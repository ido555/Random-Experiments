package more_collections.Ex4_ArrayList_with_OOP_3;

public class Chair extends Furniture {
	private int numOfLegs;

	public Chair(int length, int width, int height, String color, int numOfLegs) {
		super(length, width, height, color); // mouse over "super" and press f3 to see where it goes
		this.numOfLegs = numOfLegs;
	}

	@Override
	public void draw() {
		System.out.println("  i______i");
		System.out.println("  I______I");
		System.out.println("  I      I");
		System.out.println("  I______I");
		System.out.println(" /      /I");
		System.out.println("(______( I");
		System.out.println("I I    I I");
		System.out.println("I      I");
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public String toString() {
		return "Chair [numOfLegs=" + numOfLegs + ", Length=" + getLength() + ", Width=" + getWidth() + ", Height="
				+ getHeight() + ", Color=" + getColor() + "]";
	}
}

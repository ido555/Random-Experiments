package oop_Exercises.Ex3;

public class Table extends Furniture {
	private int numOfseats;

	public Table(int length, int width, int height, String color, int numOfseats) {
		super(length, width, height, color); // mouse over "super" and press f3 to see where it goes
		this.numOfseats = numOfseats;
	}

	@Override
	public void draw() {
		System.out.println("   =====================");
		System.out.println("  /                   /");
		System.out.println(" /                   /|");
		System.out.println("===================== |");
		System.out.println(" | |               |  |");
		System.out.println(" | |               |  |");
		System.out.println(" | |               |  |");
		System.out.println(" |                 |");
		System.out.println(" |                 |");
		System.out.println(" |                 |");
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfseats = numOfLegs;
	}

	public int getNumOfLegs() {
		return numOfseats;
	}

	public String toString() {
		return "Table [numOfseats=" + numOfseats + ", Length=" + getLength() + ", Width=" + getWidth() + ", Height="
				+ getHeight() + ", Color=" + getColor() + "]";
	}
}
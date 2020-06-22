package d05_adapter;

public class ModernRectangle extends Rectangle {

	public ModernRectangle(int x, int y, int width, int height) {
		super(x, y, x + width, y + height);
	}

	public int getHeight() {
		return getY2() - getY1();
	}
	
	public int getWidth() {
		return getX2() - getX1();
	}

	@Override
	public String toString() {
		return "ModernRectangle [X=" + getX1() + ", Y=" + getY1() + ", Width=" + getWidth() + ", Height="
				+ getHeight() + "]";
	}
		
	
}

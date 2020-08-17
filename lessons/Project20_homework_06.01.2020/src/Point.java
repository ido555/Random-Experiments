
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		try {
			if (x >= 0 && y >= 0) {
				changeX(x);
				changeY(y);
			} else // one liners dont need {}
				throw new NegativeNumberException();
			
		} catch (NegativeNumberException e) {
			e.printStackTrace();// for debugging
			System.exit(-1); // stop program completely // for debugging
		}

	}

	public int getX() {
		return x;
	}

	public void changeX(int x) {
		try {
			if (this.x + x >= 0) {
				this.x += x;
			} else // one liners dont need {}
				throw new NegativeNumberException();
			
		} catch (NegativeNumberException e) {
			e.printStackTrace(); // for debugging
			System.exit(-1); // stop program completely // for debugging
		}
	}

	public int getY() {
		return y;
	}

	public void changeY(int y) {
		try {
			if (this.y + y >= 0) {
				this.y += y;
			} else // one liners dont need {}
				throw new NegativeNumberException();
			
		} catch (NegativeNumberException e) {
			e.printStackTrace();// for debugging
			System.exit(-1); // stop program completely // for debugging
		}

	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

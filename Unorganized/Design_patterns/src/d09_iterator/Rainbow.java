package d09_iterator;

import java.util.Iterator;

public class Rainbow implements Iterable<String>{
	
	public String firstColor = "Red";
	public String secondColor = "Yellow";
	public String thirdColor = "Orange";
	public String fourthColor = "Magenta";
	public String fifthColor = "Green";
	
	
	@Override
	public Iterator<String> iterator() {
		return new RainbowIterator();
	}
	
	private class RainbowIterator implements Iterator<String>{

		private int position = 0;
		
		@Override
		public boolean hasNext() {
			return position < 5;
		}

		@Override
		public String next() {
			position++;
			switch (position) {
			case 1:
				return firstColor;
			case 2:
				return secondColor;
			case 3:
				return thirdColor;
			case 4:
				return fourthColor;
			case 5:
				return fifthColor;

			default:
				return null;
			}
		}
		
	}
	

}

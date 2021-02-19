package d09_iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Program {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("One");
		names.add("Two");
		names.add("Three");
		names.add("Four");
		
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Rainbow rainbow = new Rainbow();
		Iterator<String> iterator = rainbow.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}

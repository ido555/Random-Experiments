package exceptions;

import java.util.ArrayList;

public class Exceptions_try_catch {

	public static void main(String[] args) {
		ArrayList<String> texts = new ArrayList<String>();
		texts.add("A");
		texts.add("B");
		texts.add("C");
		texts.add("D");
		System.out.println(texts);
		
		try {
			texts.remove(10); // causes IndexOutOfBoundsException
			texts.add(10, "E"); // wont ever execute
		} catch (IndexOutOfBoundsException ex) { // Error type and what its saved into
			System.out.println("Error! " + ex.getMessage());
		}
		System.out.println(texts);
		System.out.println("End");
	}

}

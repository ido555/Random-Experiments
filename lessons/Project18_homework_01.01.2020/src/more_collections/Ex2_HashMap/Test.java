package more_collections.Ex2_HashMap;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		HashMap<String, String> people = new HashMap<String, String>();
		people.put("A1234", "Steve Jobs");
		people.put("A1235", "Scott McNealy");
		people.put("A1236", "Jeff Bezos");
		people.put("A1237", "Bill Gates");

		System.out.println();
		for (String key : people.keySet()) {
			System.out.print(key + " " + people.get(key));
			System.out.println();
		}

		// add new people without overwriting
		String id1 = "A1238";
		String name1 = "John Doe";

		String id2 = "A1238";
		String name2 = "John Doe";
		
		// didnt want to start complicating things with a while loop and a scanner
		if (!people.containsKey(id1)) { // checks if id already exists if not adds the id with corresponding name
			people.put(id1, name1);
		}
		if (!people.containsKey(id2)) {
			people.put(id2, name2);
		}
		
		System.out.println();
		for (String key : people.keySet()) {
			System.out.print(key + " " + people.get(key));
			System.out.println();
		}
	}

}
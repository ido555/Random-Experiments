package collections_HashSet_ArrayList_HashMap;

import java.util.HashMap;

public class _HashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> students = new HashMap<Integer, String>(); // key and value. every element has a key
		students.put(128, "Nir Gal");
		students.put(256, "Gal Nir");
		students.put(512, "Nir Gal");
		System.out.println(students);

		students.put(512, "Girr Gal"); // overrides value at key
		System.out.println(students);

		students.put(1024, "Bir Bal");
		students.put(2048, "Boink Dal");
		System.out.println(students);

		System.out.println("is 128 a valid key? " + students.containsKey(128));
		// System.out.println(students.containsValue(""));
		System.out.println(students.get(2048));
		System.out.println(students.keySet()); // returns Set dont know what that is yet.

		// create a HashMap of customer names attached to customer emails
		// add a few emails and names to the HashMap
		
		System.out.println("\n=========================\n");
		HashMap<String, String> customers = new HashMap<String, String>(); // mail // name
		customers.put("eaaeeemailleil1@gmail", "John doe");
		customers.put("emas@gmail", "Jeff bezos");
		System.out.println(customers);
		for (String key : customers.keySet()) { // for every key at student.keySet
			System.out.println(key + " " + customers.get(key)); // student at key
		}

	}

}

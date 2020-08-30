package collections_HashSet_ArrayList_HashMap;

import java.util.HashSet;

public class Collection_2_Hashset { // Unordered (no index) and can only hold unique values

	public static void main(String[] args) {
		HashSet<String> names = new HashSet<String>();
		names.add("One");
		names.add("Two");
		names.add("Three");
		names.add("Four");
		System.out.println(names);

		names.add("Two");
		names.add("Four"); // no duplicates IMPORTANT
		names.add("baour");
		names.add("faour");
		System.out.println(names); // no order or index IMPORTANT

//		Iterator<String> iterator = names.iterator(); // IMPORTANT
//		while (iterator.hasNext()) { // while has more elements
//			System.out.println(iterator.next()); // returns element
//		}
		// for each.  replaces the hasNext and Iterator thing above
		for (String name : names) {  // Type name : in collection
			System.out.println(name);
		}

	}

}

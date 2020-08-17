package collections_HashSet_ArrayList_HashMap;

import java.util.ArrayList;

public class Collection_1_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> texts = new ArrayList<String>(); // <Generic>
		texts.add("One");
		texts.add("Two");
		texts.add(1, "Three"); // between one and two
		System.out.println(texts.toString());

		// texts.set(3, "Four"); // runtime error

		texts.remove(1);
		System.out.println(texts.toString());
		System.out.println(texts.get(0));
		System.out.println();
		
		for (int i = 0; i < texts.size(); i++) {
			System.out.println(texts.get(i));
		}
		System.out.println();
		for(String text : texts) {
			System.out.println(text);
		}
	}
}
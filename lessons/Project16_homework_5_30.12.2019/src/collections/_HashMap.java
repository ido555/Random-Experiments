package collections;

import java.util.HashMap;

public class _HashMap {

	public static void main(String[] args) {
		String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nisl ante,"
				+ " euismod vel malesuada sit amet, suscipit et orci. Phasellus id ultricies nulla."
				+ " Mauris pharetra quis libero id congue. Duis ac est vel elit fermentum malesuada."
				+ " Aenean a varius sapien. Aliquam luctus, ligula vel rutrum volutpat, massa neque"
				+ " tincidunt metus, ut vulputate massa risus id nisl. Nullam eleifend libero sed"
				+ " nunc congue posuere. Praesent iaculis massa tellus, a consectetur lectus elementum"
				+ " et. Integer vel rutrum libero. Fusce ultrices elit quis nulla efficitur, et efficitur"
				+ " dui facilisis. Maecenas molestie turpis justo, et viverra velit aliquet sed. Sed auctor,"
				+ " tortor quis tincidunt efficitur, elit ex pellentesque lacus, id vulputate ante sapien sed"
				+ " massa. Pellentesque semper imperdiet augue, ac facilisis eros eleifend vitae. Etiam vitae"
				+ " libero eget metus suscipit sodales eget at urna"; // use HashMap to find out number of occurrences per char
		HashMap<Character, Integer> occurrences = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			// if char does not exist add new key and count
			char tempChar = str.charAt(i);
			if (!(occurrences.containsKey(tempChar))) { // does not contain char key?
				occurrences.put(tempChar, 1);
			} else {// contains char key?
				occurrences.put(tempChar, occurrences.get(tempChar) + 1);
			}
		}
		System.out.println(occurrences);
	}
}

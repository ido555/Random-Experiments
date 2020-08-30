package collections;

import java.util.ArrayList;
import java.util.Scanner;

public class _ArrayList_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //  actually use this
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> longestStrings = new ArrayList<String>();
		strings.add("aa");
		strings.add("aaaa");
		strings.add("aaaaaaaaaaaaA");
		strings.add("aaaaaaaa");
		strings.add("aaaaaaaaaaaaB");
		strings.add("aaaaaaaaaaaaA");

		
		int maxLength = strings.get(0).length(); // first index is longest string initially
		for (String txt : strings) {
			if (txt.length() > maxLength) {
				maxLength = txt.length();
			}
		}
		System.out.println(maxLength);
		for (String txt : strings) {
			if (txt.length() == maxLength) {
				longestStrings.add(txt);
			}
		}
	System.out.println(longestStrings); // nothing said about duplicates so left like this
	scan.close();
	}

}

package string_Object_Methods_Useful_Stuff;

import java.util.Arrays;

public class _Strings {

	public static void main(String[] args) {
		String str1 = "Hallo";
		String str2 = new String("Hbllo 2");
		System.out.println("length: " + str1.length());
		System.out.println("char at 0: " + str1.charAt(0));
		System.out.println("last char: " + str1.charAt(str1.length() - 1));
		System.out.println(str2);
		System.out.println("is \"ell\" in str1? " + str1.contains("ell"));
		System.out.println("Starts with 'H'? " + str1.startsWith("H"));
		System.out.println("Starts with 'o'? " + str1.startsWith("o", 4));
		System.out.println("Substring from index 1 to 4 : " + str1.substring(1, 5)); // from 1 to 4 .. why tho
		System.out.println("replace 'l' with 'g': " + str1.replace("l", "g"));
		System.out.println("str1 compare to str2: " + str1.compareTo(str2)); // compares unicode difference between
																				// first different characters
		System.out.println(str1);
		System.out.println(Arrays.toString(str1.split("L")));
		String str3 = "Hello world! how are you";
		System.out.println(Arrays.toString(str3.split(" ")));
		// String is immutable. cannot be changed only returns new String and assigns.
		// previous String is lost in Heap memory
		
		String str4 = "a";
		for (int i = 0; i < 10; i++) {
			str4 += "b"; // bad practice. makes 10 immutable orphaned objects
		}
		
		
		StringBuilder builder = new StringBuilder(); // better than for loop and turn a += b ab abb abbb abbbb immutable nature
		for (int i = 0; i < 10; i++) {
			builder.append("b"); // starts with 16 bit and is mutable
		}
		
		System.out.println("builder = " + builder);

	}

}

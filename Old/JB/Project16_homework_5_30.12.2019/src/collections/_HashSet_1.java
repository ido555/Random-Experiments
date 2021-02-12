package collections;

import java.util.HashSet;

public class _HashSet_1 {

	public static void main(String[] args) {
		HashSet<String> texts1 = new HashSet<String>();
		HashSet<String> texts2 = new HashSet<String>();
		texts1.add("aa");
		texts1.add("aaa");
		texts1.add("aaA");
		texts1.add("aaB");
		texts1.add("aaA");
		texts1.add("aaBa");
		texts1.add("aaB");
		System.out.println(texts1);

		texts2.add("aaa");
		texts2.add("ccc");
		texts2.add("qqq");
		texts2.add("qq1q");
		texts2.add("qq2q");
		texts2.add("aaBa");
		texts2.add("fff");
		texts2.add("aaA");
		System.out.println(texts2);

		for (String txt : texts1) {
			if (texts2.contains(txt)) {
				System.out.println(txt + " was found in both sets");
			}
		}
	}
}

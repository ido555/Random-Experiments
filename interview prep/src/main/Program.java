package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Program {

	public static void main(String[] args) {
		// find missing number in array
		int[] nums = { 1, 12, 3, 5, 9, 7, 8, 6, 10, 11, 2 };
		int n = nums.length;
		int total = (n + 1) * (n + 2) / 2; // gauss sum formula ((n) * (n+1)) / 2
		for (int i = 0; i < n; i++) {
			total -= nums[i];
		}
		System.out.println(total);

		// turn all double digit numbers to 0
		int[] nums2 = { 1, 12, 3, 5, 9, 7, 8, 6, 10, 11, 2, 66, 77, 22, 4441, 2244, 44, 55 };
		System.out.println(Arrays.toString(nums2));
		for (int i = 0; i < nums2.length; i++) {
			if (nums2[i] >= 10 && nums2[i] <= 100)
				nums2[i] = 0;
		}
		System.out.println(Arrays.toString(nums2));

		LinkedList<Integer> linked = new LinkedList<Integer>();
		LinkedList<Integer> linkedReversed = new LinkedList<Integer>();
		for (int i = 0; i < 100; i++) {
			linked.add(i);
		}
		Iterator<Integer> ite = linked.descendingIterator();
		while (ite.hasNext()) {
			linkedReversed.add(ite.next());
		}
		System.out.println(linked);
		System.out.println(linkedReversed);
	}

}

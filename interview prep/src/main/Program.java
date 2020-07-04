package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Program {

	public static void main(String[] args) {
		// Complexity - O(n)
		// find missing number in array
		int[] nums = { 1, 12, 3, 5, 9, 7, 8, 6, 10, 11, 2 };
		int n = nums.length;
		int total = (n + 1) * (n + 2) / 2; // carl gauss sum formula - ((n) * (n+1)) / 2
		// sum of numbers(from 1 - 12) MINUS every number found = missing number
		for (int i = 0; i < n; i++) 
			total -= nums[i];
		System.out.println(total);
		System.out.println("=======================================================================");
		
		
		// Complexity - O(n)
		// turn all double digit numbers to 0
		int[] nums2 = { 1, 12, 3, 5, 9, 7, 8, 6, 10, 11, 2, 66, 77, 22, 4441, 2244, 44, 55 };
		System.out.println(Arrays.toString(nums2));
		for (int i = 0; i < nums2.length; i++) 
			if (nums2[i] >= 10 && nums2[i] <= 100)
				nums2[i] = 0;
		
		System.out.println(Arrays.toString(nums2));
		System.out.println("=======================================================================");

		
		// Complexity - O(n) ... probably?
		// reverse linked list
		LinkedList<Integer> linked = new LinkedList<Integer>();
		LinkedList<Integer> linkedReversed = new LinkedList<Integer>();
		// add 100 ints in order from 1 - 100
		for (int i = 1; i <= 100; i++) 
			linked.add(i);
		// iterate from head to tail
		Iterator<Integer> ite = linked.descendingIterator();
		while (ite.hasNext()) {
			linkedReversed.add(ite.next());
		}
		System.out.println(linked);
		System.out.println(linkedReversed);
		System.out.println("=======================================================================");
		
		// Complexity - O(n)
		// get middle element from linked list
		int count = 0;
		for (Integer num : linked) 
			count++;
		System.out.println(linked.get((count-1) /2));
		System.out.println("=======================================================================");
		
		//find out if this linked list is circular - cant get nodes = cant do that.
	}
	
	
	

}

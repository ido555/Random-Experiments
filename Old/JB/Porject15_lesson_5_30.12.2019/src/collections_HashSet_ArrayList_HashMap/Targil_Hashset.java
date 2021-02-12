package collections_HashSet_ArrayList_HashMap;

import java.util.HashSet;
import java.util.Random;

public class Targil_Hashset {

	public static void main(String[] args) {
		Random rand = new Random();
		HashSet<Integer> nums = new HashSet<Integer>();
		while (nums.size() < 5) { // only unique numbers are entered //we dont know how long to run to get 5 unique numbers
			nums.add(rand.nextInt(10) + 1);
		}
		System.out.println(nums);
	}
}

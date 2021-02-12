package collections;

import java.util.HashSet;
import java.util.Random;

public class _HashSet_2 {

	public static void main(String[] args) {
		HashSet<Integer> randNums = new HashSet<Integer>();
		Random rand = new Random();
		while(randNums.size() < 10) {
			randNums.add(rand.nextInt(20)+1);
		}
		System.out.println(randNums);
		int count = 0;
		for (Integer integer : randNums) {
			if (integer < 10) {
				count++;
			}
		}
		System.out.println("nums under 10: " + count);
	}

}

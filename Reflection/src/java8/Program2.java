package java8;

import java.util.function.Predicate;

public class Program2 {

	public static void main(String[] args) {
		// Predicate - get value - return boolean
		// functional interface for checking conditions
		Predicate<Integer> isOld = age -> age > 60;
		System.out.println(isOld.test(50));
		
		
	}

}

package streams2;

import java.util.stream.IntStream;

public class Program2 {

	public static void main(String[] args) {
		// .limit(100) - for java 8
		IntStream.iterate(1, n -> n <= 100, n -> n + 1).forEach(System.out::println); // java 9
		System.out.println("=================");
		long count = IntStream.iterate(1, n -> n <= 200_000, n -> n + 1)
				.parallel()
				.filter(Program2::isPrime)
				.count();
		
		System.out.println(count);
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i< Math.sqrt(number); i++)
			if (number % i == 0)
				return false;
		return false;
	}
}

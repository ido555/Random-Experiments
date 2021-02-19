package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Program2 {

	public static void main(String[] args) {
		// Predicate - gets type - returns boolean
		// functional interface for checking conditions
		Predicate<Integer> isOld = age -> age > 60;
		System.out.println(isOld.test(50));

		// Consumer - gets type - returns void
		Consumer<String> print = t -> System.out.println(t);
		print.accept("text 123");

		// Supplier - gets nothing - returns type
		Supplier<Double> r = () -> Math.random();
		System.out.println(r.get());

		// Function gets Type returns Type
		Function<String, Integer> length = s -> s.length();
		System.out.println(length.apply("Hello World!"));
		Function<String, String> appendChar = s -> s + "o";
		System.out.println(appendChar.apply("hell"));

		Stream<Integer> stream = Stream.of(1, 2, 55, 115, 66, 34, 6, 2, 88, 9, 95, 662, 22 ,44152512);
		stream.sorted().filter(n -> n % 2==0).map(n -> "Number: " + n).forEach(n-> System.out.println(n));
	}

}

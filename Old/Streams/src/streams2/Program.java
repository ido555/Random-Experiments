package streams2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		List<String> texts = Arrays.asList("Nir","Nir", "Jeffery", "Teheran", "Syria", "Iran", "America", "Ben" , "Armenia",
				"Afghanistan");

		System.out.println(texts.stream().mapToInt(text -> text.length()).summaryStatistics());
		System.out.println(texts.stream().mapToInt(t -> t.length()).average().orElse(0));

		System.out.println("===========================");
		texts.stream().forEach(t -> printLetters(t));
		System.out.println("===========================");

		List<String> afterFilter = texts.stream().filter(n -> n.length() <= 6).sorted()
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(afterFilter);
		
		System.out.println("===========================");
		Set<String> filterToSet = texts.stream().sorted()
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(filterToSet);
	}

	public static void printLetters(String text) {
		for (char c : text.toCharArray()) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

}

package streams;

import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		// create list of Strings
		// add 6 or more texts to it
		// a - print all texts beginning with 'a'
		// b - print all texts beginning with 'a' and 3 chars long
		// c print all texts plus thier length concatted as new values in the stream
		// print all texts sorted by text length
		
		List<String> texts = Arrays.asList("Nir","Jeffery","Teheran","Syria","Iran","America","Armenia","Afghanistan");
		texts.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
		System.out.println("=========================");
		texts.stream().filter(name -> name.startsWith("A")).filter(name-> name.length() >= 9).forEach(System.out::println);
		System.out.println("=========================");
		texts.stream().map(name -> name + " : " + name.length()).forEach(System.out::println);
		System.out.println("=========================");
		texts.stream().sorted((text1 ,text2) -> text1.charAt(0) - text2.charAt(0)).forEach(System.out::println);
		
	}

}

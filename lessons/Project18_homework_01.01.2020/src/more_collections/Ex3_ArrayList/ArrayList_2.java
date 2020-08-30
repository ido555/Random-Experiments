package more_collections.Ex3_ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_2 {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			words.add(scan.next());
		}
		System.out.println(words);
		scan.close();

		// words.forEach(action);
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).length() % 2 != 0) { // odd number
				words.remove(words.get(i));
			}
		}
		System.out.println(words);
	}

}

package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test_ido_s {
	public static void main(String[] args) {
		char[] colors = { 'r', 'g', 'b', 'y', 'o' };
		char[] chosenColors = new char[3];
		int numOfGuesses = 1;
		generateColors(chosenColors, colors);
		System.out.println(Arrays.toString(chosenColors)); // cheat to show the correct combination
		System.out.println("Enter your guesses input should be one of the following:");
		System.out.println("r , g , b , y , o.  or  red, green, blue, yellow, orange. and each color only once");

		while (checkUserGuesses(chosenColors) == true) {
			numOfGuesses++;
			System.out.println("\ntry again");
		}
		System.out.println("\nCorrect! you took: " + numOfGuesses + " guess(es)");

	}

	public static boolean checkUserGuesses(char[] chosenColors) {
		Scanner scan = new Scanner(System.in);
		char[] userGuesses = new char[3];

		// check if user entered color more than once
		lbl: for (int i = 0; i < userGuesses.length; i++) {
			char entry = scan.next().charAt(0);
			boolean isFound = false;
			for (int j = 0; j < userGuesses.length; j++) {
				if (entry == userGuesses[j]) {
					isFound = true;
					System.out.println("already entered" + userGuesses[i]);
					i--;
					continue lbl;
				}
			}
			if (isFound == false) {
				userGuesses[i] = entry;
			}
		}

		boolean mistake = false;
		for (int i = 0; i < userGuesses.length; i++) {
			boolean isFound = false;
			if (userGuesses[i] == chosenColors[i]) {
				System.out.print("x");
				continue;
			} else {
				for (int j = 0; j < chosenColors.length; j++) {
					if (userGuesses[i] == chosenColors[j]) {
						System.out.print("o");
						isFound = true;
						mistake = true;
						break;
					}
				}
			}
			if (isFound == false) {
				mistake = true;
				System.out.print("_");
			}
		}
		return mistake;
	}

	public static char[] generateColors(char[] chosenColors, char[] colors) {
		Random rand = new Random();
		for (int i = 0; i < chosenColors.length; i++) {
			char color = colors[rand.nextInt(colors.length)]; // choose random color to add

			boolean isFound = false;
			for (int j = 0; j < chosenColors.length; j++) { // check entire array if color already exists
				if (chosenColors[j] == color) {
					isFound = true;
					i--; // color already exists? try again // will never happen on the first index
				}
			}
			if (isFound == false) { // color does not exist in chosenColors[] ?
				chosenColors[i] = color; // place it in the first available index
			}

		}
		return chosenColors;
	}
}

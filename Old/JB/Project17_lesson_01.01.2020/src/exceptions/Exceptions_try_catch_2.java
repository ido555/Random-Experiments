package exceptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exceptions_try_catch_2 {
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int index;
		for (int i = 0; i < 5; i++) {
			while (true) {
				try {
					Scanner scan = new Scanner(System.in);
					// scanner will close once an error is made so this opens it again

					System.out.print("enter a number: ");
					index = scan.nextInt();
					nums.add(index, rand.nextInt());
					break;

				} catch (InputMismatchException e) {
					System.out.println("invalid input");

				} catch (IndexOutOfBoundsException e) {
					System.out.println(e.getMessage() + " out of bounds");
				}
			}
		}
		System.out.println("you entered the number: " + nums);

	}
}

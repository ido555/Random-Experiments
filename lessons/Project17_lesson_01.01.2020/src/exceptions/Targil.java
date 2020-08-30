package exceptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Targil {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			while (true) {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.println("enter a number");
					int a = scan.nextInt();
					while (a == 0) {
						System.out.println("cant be 0");
						a = scan.nextInt();
					}
					nums.add(a);
					break;
				} catch (InputMismatchException e) {
					System.out.println("invalid input");
				}
			}

		}
		System.out.println((double) nums.get(0) / nums.get(1));
//		DecimalFormat f = new DecimalFormat("#.###");
//
//		System.out.println(f.format((double) nums.get(0) / nums.get(1)));

	}
}

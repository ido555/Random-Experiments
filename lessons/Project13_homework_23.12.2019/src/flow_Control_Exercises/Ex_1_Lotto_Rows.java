package flow_Control_Exercises;

import java.util.Random;
import java.util.Scanner;

public class Ex_1_Lotto_Rows {

	public static void main(String[] args) {
		// make programs that outputs
		System.out.println("how many rows of 6: ");
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		int input = scan.nextInt();
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print((rand.nextInt(37) + 1) + "\t ");
			}
			System.out.println();
		}
		scan.close();
	}

}

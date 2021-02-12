package oop_Exercises.Ex3;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Furniture[] furn = new Furniture[20];
		// choose random color
		String[] colors = { "red", "blue", "black", "white" };

		for (int i = 0; i < furn.length; i++) {
			int height = rand.nextInt(10) + 10, width = rand.nextInt(10) + 10, length = rand.nextInt(10) + 10; // random height width and length

			String color = colors[rand.nextInt(colors.length)]; // 0 - 3 // random color
			switch (rand.nextInt(3)) { // 0 - 2 // random type
			case 0:
				furn[i] = new Bed(length, width, height, color, rand.nextBoolean()); // true / false
				furn[i].draw(); // draw bed
				Bed bed = (Bed) furn[i]; // explicit cast from Furn type to Bed type so i could use methods exclusive to Bed
				// i.e. isKingSize
				System.out.println("king size? " + bed.isKingSize());
				break;
			case 1: // exact same as bed
				furn[i] = new Chair(length, width, height, color, rand.nextInt(4) + 4); // 4 - 8
				furn[i].draw();
				Chair chair = (Chair) furn[i];
				System.out.println("Number of legs: " + chair.getNumOfLegs());
				break;
			case 2: // exact same as bed
				furn[i] = new Table(length, width, height, color, rand.nextInt(8) + 2); // 2 - 10
				furn[i].draw();
				Table table = (Table) furn[i];
				System.out.println("Number of seats: " + table.getNumOfLegs());
				break;
			}

		}

		for (int i = 0; i < furn.length; i++) { // i think this is what they meant by "display" ?
			System.out.println(furn[i].toString());
		}
	}
}

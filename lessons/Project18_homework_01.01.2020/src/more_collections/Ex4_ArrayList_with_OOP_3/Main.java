package more_collections.Ex4_ArrayList_with_OOP_3;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		//Furniture[] furn = new Furniture[20];
		ArrayList<Furniture> furn = new ArrayList<Furniture>();
		// choose random color
		String[] colors = { "red", "blue", "black", "white" };

		for (int i = 0; i < 20; i++) {
			int height = rand.nextInt(10) + 10, width = rand.nextInt(10) + 10, length = rand.nextInt(10) + 10; // random height width and length

			String color = colors[rand.nextInt(colors.length)]; // 0 - 3 // random color
			switch (rand.nextInt(3)) { // 0 - 2 // random type
			case 0:
				//furn[i] = new Bed(length, width, height, color, rand.nextBoolean()// true / false
				furn.add(new Bed(length, width, height, color, rand.nextBoolean() ));
				//
				//furn[i].draw(); // draw bed
				furn.get(i).draw();
				Bed bed = (Bed) furn.get(i); // explicit cast from Furn type to Bed type so i could use methods exclusive to Bed
				// i.e. isKingSize
				System.out.println("king size? " + bed.isKingSize());
				break;
			case 1: // exact same as bed
				//furn[i] = new Chair(length, width, height, color, rand.nextInt(4) + 4); // 4 - 8
				//furn[i].draw();
				furn.add(new Chair(length, width, height, color, rand.nextInt(4) + 4));
				furn.get(i).draw();
				Chair chair = (Chair) furn.get(i);
				System.out.println("Number of legs: " + chair.getNumOfLegs());
				break;
			case 2: // exact same as bed
//				furn[i] = new Table(length, width, height, color, rand.nextInt(8) + 2); // 2 - 10
//				furn[i].draw();
				furn.add(new Table(length, width, height, color, rand.nextInt(8) + 2));
				furn.get(i).draw();
				Table table = (Table) furn.get(i);
				System.out.println("Number of seats: " + table.getNumOfLegs());
				break;
			}

		}

		for (int i = 0; i < furn.size(); i++) { // i think this is what they meant by "display" ?
			System.out.println(furn.get(i).toString());
		}
	}
}

package io_homework_targil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class _IO_Targil {

	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>(); // ArrayList must be Serializable to be written into files
		// 
		// switch case
		// 1 random number
		// 2 syso inputs list
		// 3 save list to actual file
		// 4 load list from file and overwrite current inputs arraylist from memory
		// 5 syso sum of numbers from ArrayList given from file
		// 6 syso average of numbers from ArrayList
		// 7 syso max number from ArrayList 
		// 8 syso min number from ArrayList 
		// 9 end program

		// io stream - binary code stream - byte stream
		/* byte stream = (text,image,audio,whatever).*/
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		// FileInputStream fis = new FileInputStream("file.txt");   // read byte stream(text,image,audio,whatever) from file
		// FileOutputStream fos = new FileOutputStream("file.txt");   // write byte stream to file // output byte stream to OS path.file
		/*
		 FileOutputStream is meant for writing streams of raw bytes such as image data. // this is why im using fos, for an object.
		  For writing streams of characters, consider using FileWriter.

		 FileInputStream is meant for reading streams of raw bytes such as image data. // same as above
		  For reading streams of characters, consider using FileReader.
		 */
		
		
		// ObjectInputStream ois = new ObjectInputStream(fis);   // Interpret FileInputStream data as as an Object byte stream
		// ObjectOutputStream oos = new ObjectOutputStream(fos);   // Give FileOutputStream an Object as a byte stream // translate object to byte stream
		
		System.out.println("Enter choice\n"
				+ "1. add random number to inputs list\n"
				+ "2. print inputs saved in memory\n"
				+ "3. save input list to file\n"
				+ "4. load input list from file and overwrite current inputs list\n"
				+ "5. print inputs sum\n"
				+ "6. print inputs average\n"
				+ "7. print largest number\n"
				+ "8. print smallest number\n"
				+ "9. end program");
		
		int sum = 0, count = 0, min = 0, max = 0;
		while (true) {
			int input = scan.nextInt();
			switch (input/*key*/) {
			case 1:/* key = 1*/
				inputs.add(rand.nextInt(1000)+1);
				System.out.println("Random number added");
				break;
			case 2:/* key = 2*/
				System.out.println(inputs);
				break;
			case 3:
				try (FileOutputStream fos = new FileOutputStream("arraylistfile.txt"); // this file is saved in its source folder which for me is at
						// C:\Users\USERNAME\git\lesson-12-23.12.2019_and_on\Project23_homework_08.01.2020\arraylistfile.txt
						ObjectOutputStream oos = new ObjectOutputStream(fos)){
					oos.writeObject(inputs); //
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} // auto closes fos and oos. like adding a finally clause but automatically
				System.out.println("ArrayList saved");
				break;
			case 4:
				try (FileInputStream fis = new FileInputStream("arraylistfile.txt"); 
						ObjectInputStream ois = new ObjectInputStream(fis)){
						                                               inputs = (ArrayList<Integer>) ois.readObject();
					 
				} catch (IOException | ClassNotFoundException | TypeMismatchException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("ArrayList loaded");
				break;
				/*some of the code wont work with am empty array - no 0 size array checks*/
			case 5:
				sum = 0;
				for (Integer number : inputs) {
					sum += number;
				}
				System.out.println("Sum is:" + sum);
				break;
			case 6: //
				sum = 0;
				count = 0;
				for (Integer number : inputs) {
					sum += number;
					count++;
				}
				System.out.println("Average of" + inputs + " is: " + sum / count);
				break;
			case 7:
				max = inputs.get(0); //
				for (int number : inputs) {
					if (number > max) {
						max = number;
					}
				}
				System.out.println("Largest number is: " + max);
				break;
			case 8: //
				min = inputs.get(0);
				for (int number : inputs) {
					if (number < min) {
						min = number;
					}
				}
				System.out.println("Smallest number is: " + min);
				break;
			case 9:
				System.out.println("Bye");
				scan.close();
				return;

			default:/*key is not handled in any case clause*/ // if any integer that doesnt have a case is entered
				System.out.println("a valid input is 1 - 9");
				break;
			}
		}
	}
}
